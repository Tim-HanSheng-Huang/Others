
data=read.csv("C:/Users/user/Desktop/ALL_DATA_English.csv",encoding='UTF-8')
background=read.csv("C:/Users/user/Desktop/candidates_background.csv")

#data_X <- subset(data, select=-c(likes,love,haha,wow))
#data_X <- subset(data, select=c(live,video))
data_X <- subset(data, select=c(log_posts,soft,dynamic))


dataX_only_liway <- data_X[-c(94:103),] 

E.dist <- dist(dataX_only_liway, method="euclidean") #歐式距離
#M.dist <- dist(dataX_only_liway, method="manhattan") #曼哈頓距離

par(mfrow=c(1,2)) 

# 使用歐式距離進行分群
h.E.cluster <- hclust(E.dist)
plot(h.E.cluster, xlab="歐式距離")

# 使用曼哈頓距離進行分群
h.M.cluster <- hclust(M.dist) 
plot(h.M.cluster, xlab="曼哈頓距離")

E.dist <- dist(dataX_only_liway, method="euclidean")
h.cluster <- hclust(M.dist, method="ward.D2") # 華德法

# 視覺化
plot(h.cluster)
abline(h=2, col="red")

cut.h.cluster <- cutree(h.cluster, k=2) 
cut.h.cluster                            # 分群結果

table(cut.h.cluster,background$party)
table(cut.h.cluster,background$status)
table(cut.h.cluster,background$selected)
table(cut.h.cluster, background$age)


# Elbow Method 應用在 階層式分析
# 注意：這裡使用的是hcut()，屬於factoextra套件，並非上面提的hclust()
fviz_nbclust(dataX_only_liway, 
             FUNcluster = hcut,  # hierarchical clustering
             method = "wss",     # total within sum of square
             k.max = 12          # max number of clusters to consider
) + 
  
  labs(title="Elbow Method for HC")


# 視覺化 k-means 分群結果(基於ggplot2的語法)
#install.packages("factoextra")
#require(factoextra)
fviz_cluster(cut.h.cluster,           # 分群結果
             data = dataX_only_liway, # 資料
             geom = c("point","text"), 
             frame.type = "norm")      # 框架型態

#install.packages("rgl")
library(rgl)
#plot3d(dataX_only_liway$soft,dataX_only_liway$dynamic,dataX_only_liway$log_posts,col=cut.h.cluster$cluster)
scatter3D(dataX_only_liway$soft, dataX_only_liway$dynamic, dataX_only_liway$log_posts,labels=rownames(dataX_only_liway),colvar=cut.h.cluster,col = c("#1B9E77", "#D95F02", "#7570B3"),theta=300,phi=-10,add=FALSE,pch = 19,cex =1 )

