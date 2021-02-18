require(factoextra)
data=read.csv("C:/Users/user/Desktop/ALL_DATA_ English.csv",encoding='UTF-8')
background=read.csv("C:/Users/user/Desktop/candidates_background.csv")

#data_X <- subset(data, select=-c(Candidate,likes,love,haha,wow))
#data_X <- subset(data, select=c(likes,live))
data_X<-data

par(mfrow=c(1,1))
dataX_only_liway <- data_X[-c(94:103),] 

pca <- prcomp(formula = ~ text+hyperlink+live+video+photo+self_image+policy+attack+response+promote+sharing_issue+others+posts+shares+comments+likes+wow+haha+love,
              data = dataX_only_liway,               # 資料
              scale = TRUE)                          # 正規化資料

# 使用plot()函式
plot(pca,         
     type="line",
     main="Scree Plot")

# 用藍線標示出特徵值=1的地方
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

# 群內的變異數
kmeans.cluster$withinss

table(kmeans.cluster$cluster, background$party)  
table(kmeans.cluster$cluster, background$status)
table(kmeans.cluster$cluster, background$selected)
table(kmeans.cluster$cluster, background$gender)
table(kmeans.cluster$cluster, background$age)
table(kmeans.cluster$cluster, background$district)

# 視覺化 k-means 分群
#install.packages("factoextra")
#require(factoextra)
fviz_cluster(kmeans.cluster,           # 分群結果
             data = dataX_only_liway ,   # 資料
             geom = c("point","text"), 
             frame.type = "norm")      # 框架型態

# Elbow Method 應用在 K-Means
fviz_nbclust( top7_pca.data, 
             FUNcluster = kmeans,# K-Means
             method = "wss",     # total within sum of square
             k.max = 12          # max number of clusters to consider
) +
  
  labs(title="Elbow Method for K-Means")

kmeans.cluster
