
#data=read.csv("C:/Users/user/Desktop/ALL_DATA_English.csv",encoding='UTF-8')
data=read.csv("C:/Users/user/Desktop/ALL_DATA_English.csv")
background=read.csv("C:/Users/Paula/Desktop/candidates_background.csv",fileEncoding ="UTF-8")
#background<-background[-41,]

#data_X <- subset(data, select=-c(嚜澧andidate,soft,hard,dynamic,traditional,love,haha,wow))
#data_X <- subset(data, select=-c(嚜澧andidate,self_image,policy,attack,response,promote,sharing_issue,like,love,haha,wow))
data_X <- subset(data, select=c(soft,dynamic))
#data_X<-subset(data,select=-c(1,2))

dataX_only_liway <- data_X[-c(94:103),] 
#dataX_only_liway <- data_X[(17:94),] 
#dataX_only_liway <- data_X[-c(59),]
#dataX_only_liway<-data_X[-41]

# 分成三群
kmeans.cluster <- kmeans(dataX_only_liway,algorithm=c("MacQueen"), centers=3) 

# 群內的變異數
kmeans.cluster$withinss


table(kmeans.cluster$cluster, background$party)  
table(kmeans.cluster$cluster, background$status)
table(kmeans.cluster$cluster, background$selected)
table(kmeans.cluster$cluster, background$gender)
table(kmeans.cluster$cluster, background$age)
table(kmeans.cluster$cluster, background$district)

# 視覺化 k-means 分群結果(基於ggplot2的語法)
#install.packages("factoextra")
require(factoextra)
fviz_cluster(kmeans.cluster,           # 分群結果
             data = dataX_only_liway,              # 資料
             ellipse=FALSE,
             pointsize=3,
             geom = c("point"), 
             frame.type = "norm")      # 框架型態

fviz_cluster(background$party,           # 分群結果
             data = dataX_only_liway,              # 資料
             ellipse=FALSE,
             pointsize=3,
             geom = c("point"), 
             frame.type = "norm")      # 框架型態



#Elbow Method 應用在 K-Means
fviz_nbclust(dataX_only_liway, 
            FUNcluster = kmeans,# K-Means
           method = "wss",     # total within sum of square
          k.max = 12          # max number of clusters to consider
) +
  
labs(title="Elbow Method for K-Means")


kmeans.cluster

#install.packages("rgl")
library("plot3D")
#library(rgl)
#plot3d(dataX_only_liway$soft,dataX_only_liway$dynamic,dataX_only_liway$log_posts,col=kmeans.cluster$cluster)
scatter3D(dataX_only_liway$soft, dataX_only_liway$dynamic, dataX_only_liway$log_posts,labels=rownames(dataX_only_liway),colvar =kmeans.cluster$cluster,col = c("#1B9E77", "#D95F02", "#7570B3"),theta=150,phi=-10,add=FALSE,pch = 19,cex =1 )

library(ggplot2)
cluster_outcome <- as.factor(kmeans.cluster$cluster)
# Basic scatter plot
ggplot(dataX_only_liway, aes(x=dataX_only_liway$soft, y=dataX_only_liway$dynamic,color=cluster_outcome)) + geom_point(size=3)+geom_text(label=background$name,nudge_x = 0.01,nudge_y= -0.01)





