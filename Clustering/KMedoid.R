
data=read.csv("C:/Users/user/Desktop/ALL_DATA_ English.csv",encoding='UTF-8')
background=read.csv("C:/Users/user/Desktop/candidates_background.csv")

#data_X <- subset(data, select=-c(likes,love,haha,wow))
#data_X <- subset(data, select=c(live,attack))
data_X <- subset(data, select=c(log_posts,soft,dynamic))

dataX_only_liway <- data_X[-c(94:103),] 
#dataX_only_liway <- data_X[-c(59),] 


require(cluster)

# pam = Partitioning Around Medoids
kmedoid.cluster <- pam(data, k=4) 

# 群內的變異數
kmedoid.cluster$objective


# 分群結果和實際結果比較
table(kmedoid.cluster$clustering, background$party) 
table(kmedoid.cluster$clustering, background$selected) 
table(kmedoid.cluster$clustering, background$status) 
table(kmedoid.cluster$cluster, background$age)

# 視覺化 k-medoid 分群結果(基於ggplot2的語法)
require(factoextra)
fviz_cluster(kmedoid.cluster,       # 分群結果
             data = dataX_only_liway,           # 資料
             geom = c("point","text"),    
             frame.type = "norm")   # 框架型態

# Elbow Method 應用在 K-Medoid
fviz_nbclust(dataX_only_liway, 
             FUNcluster = pam,   # K-Medoid
             method = "wss",     # total within sum of square
             k.max = 12          # max number of clusters to consider
)+
  
  labs(title="Elbow Method for K-Medoid")

scatter3D(dataX_only_liway$soft, dataX_only_liway$dynamic, dataX_only_liway$log_posts,labels=rownames(dataX_only_liway),colvar=kmedoid.cluster$cluster,col = c("#1B9E77", "#D95F02", "#7570B3"),theta=150,phi=-10,add=FALSE,pch = 19,cex =1 )

