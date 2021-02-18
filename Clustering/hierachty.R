
data=read.csv("C:/Users/user/Desktop/ALL_DATA_English.csv",encoding='UTF-8')
background=read.csv("C:/Users/user/Desktop/candidates_background.csv")

#data_X <- subset(data, select=-c(likes,love,haha,wow))
#data_X <- subset(data, select=c(live,video))
data_X <- subset(data, select=c(log_posts,soft,dynamic))


dataX_only_liway <- data_X[-c(94:103),] 

E.dist <- dist(dataX_only_liway, method="euclidean") #�ڦ��Z��
#M.dist <- dist(dataX_only_liway, method="manhattan") #�ҫ��y�Z��

par(mfrow=c(1,2)) 

# �ϥμڦ��Z���i����s
h.E.cluster <- hclust(E.dist)
plot(h.E.cluster, xlab="�ڦ��Z��")

# �ϥΰҫ��y�Z���i����s
h.M.cluster <- hclust(M.dist) 
plot(h.M.cluster, xlab="�ҫ��y�Z��")

E.dist <- dist(dataX_only_liway, method="euclidean")
h.cluster <- hclust(M.dist, method="ward.D2") # �ؼw�k

# ��ı��
plot(h.cluster)
abline(h=2, col="red")

cut.h.cluster <- cutree(h.cluster, k=2) 
cut.h.cluster                            # ���s���G

table(cut.h.cluster,background$party)
table(cut.h.cluster,background$status)
table(cut.h.cluster,background$selected)
table(cut.h.cluster, background$age)


# Elbow Method ���Φb ���h�����R
# �`�N�G�o�̨ϥΪ��Ohcut()�A�ݩ�factoextra�M��A�ëD�W������hclust()
fviz_nbclust(dataX_only_liway, 
             FUNcluster = hcut,  # hierarchical clustering
             method = "wss",     # total within sum of square
             k.max = 12          # max number of clusters to consider
) + 
  
  labs(title="Elbow Method for HC")


# ��ı�� k-means ���s���G(���ggplot2���y�k)
#install.packages("factoextra")
#require(factoextra)
fviz_cluster(cut.h.cluster,           # ���s���G
             data = dataX_only_liway, # ���
             geom = c("point","text"), 
             frame.type = "norm")      # �ج[���A

#install.packages("rgl")
library(rgl)
#plot3d(dataX_only_liway$soft,dataX_only_liway$dynamic,dataX_only_liway$log_posts,col=cut.h.cluster$cluster)
scatter3D(dataX_only_liway$soft, dataX_only_liway$dynamic, dataX_only_liway$log_posts,labels=rownames(dataX_only_liway),colvar=cut.h.cluster,col = c("#1B9E77", "#D95F02", "#7570B3"),theta=300,phi=-10,add=FALSE,pch = 19,cex =1 )
