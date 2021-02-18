require(factoextra)
data=read.csv("C:/Users/user/Desktop/ALL_DATA_ English.csv",encoding='UTF-8')
background=read.csv("C:/Users/user/Desktop/candidates_background.csv")

#data_X <- subset(data, select=-c(Candidate,likes,love,haha,wow))
#data_X <- subset(data, select=c(likes,live))
data_X<-data

par(mfrow=c(1,1))
dataX_only_liway <- data_X[-c(94:103),] 

pca <- prcomp(formula = ~ text+hyperlink+live+video+photo+self_image+policy+attack+response+promote+sharing_issue+others+posts+shares+comments+likes+wow+haha+love,
              data = dataX_only_liway,               # ���
              scale = TRUE)                          # ���W�Ƹ��

# �ϥ�plot()�禡
plot(pca,         
     type="line",
     main="Scree Plot")

# ���Žu�ХܥX�S�x��=1���a��
abline(h=1, col="blue") # Kaiser eigenvalue-greater-than-one rule

vars <- (pca$sdev)^2  
props <- vars / sum(vars)    
cumulative.props <- cumsum(props)  
cumulative.props
cumulative.props[7]
plot(cumulative.props[1:7])

# pca$rotation 
top7_pca.data <- pca$x[, 1:7]
top7_pca.data 

kmeans.cluster <- kmeans(top7_pca.data, centers=5) 

# �s�����ܲ���
kmeans.cluster$withinss

table(kmeans.cluster$cluster, background$party)  
table(kmeans.cluster$cluster, background$status)
table(kmeans.cluster$cluster, background$selected)
table(kmeans.cluster$cluster, background$gender)
table(kmeans.cluster$cluster, background$age)
table(kmeans.cluster$cluster, background$district)

# ��ı�� k-means ���s
#install.packages("factoextra")
#require(factoextra)
fviz_cluster(kmeans.cluster,           # ���s���G
             data = dataX_only_liway ,   # ���
             geom = c("point","text"), 
             frame.type = "norm")      # �ج[���A

# Elbow Method ���Φb K-Means
fviz_nbclust( top7_pca.data, 
             FUNcluster = kmeans,# K-Means
             method = "wss",     # total within sum of square
             k.max = 12          # max number of clusters to consider
) +
  
  labs(title="Elbow Method for K-Means")

kmeans.cluster