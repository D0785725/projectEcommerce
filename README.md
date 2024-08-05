
E-commerce Project


基於Spring Boot構建的電子商務平台，支持商品的展示、購物車、訂單管理和支付功能。
![商品選單](https://github.com/user-attachments/assets/38e9b25f-11be-4aba-a751-ee8c5e6f58ea)

主要功能
 - 商品管理：可以查看商品列表，管理商品資訊。
 - 購物車：用戶可以將商品添加到購物車，調整數量，並查看購物車內容。
 - 訂單處理：支持創建訂單，查詢訂單狀態。
 - 支付：集成了PayPal支付配置，用戶可以通過PayPal完成支付。
 - 用戶管理：管理用戶資訊，包括註冊、登錄、用戶資料修改等。


![擷取](https://github.com/user-attachments/assets/8b173c84-ba63-4458-a5de-c0b36ccb545b)
![擷取](https://github.com/user-attachments/assets/788bebf0-2732-4f45-be02-aa6aa17d9fc1)
未來增加功能
 - ELK綁定log管理，每月產生報表
 - 提供搜尋功能
 - 提供地圖定位導引功能

配置應用
修改src/main/resources/application.properties文件

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username= 你的username
spring.datasource.password= 你的pwd
spring.jpa.hibernate.ddl-auto=update

開發環境
Java
Spring Boot
Maven
MySQL
PayPal API

#
project目的:為了將基本技能收斂在一個點上，以更好的往下一個知識點推進，所以做一個陽春的前後端結合的應用。
因在環境上有許多side project可以選擇，故選擇用電商平台作為練習的項目。
學習項目- 
 - 基於spring框架 收斂spring boot, spring security, spring web 了解之間差異 
 - java上開發撰寫restful api框架
 - 了解JPA和學習使用JDBC提升效能
 - 單元測試
