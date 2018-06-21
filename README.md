# spring-boot-weixin
微信测试公众号

# MyConst 
配置微信公众号的 AppID, appsecret

# WeiXinController
公众号开发者模式接入

# WeixinClient
Token 需要自己在网页上获取，填写到 

# WeixinService
微信公众号目录创建，模板信息发送 

# War 包
使用maven package

# 直接运行
修改 pom 
  ```
  <packaging>jar</packaging>
  ```
  
  注释掉这个依赖
  ```
  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
	</dependency>
  ```
修改 Application
  删除继承 SpringBootServletInitializer， 只留下 main 方法, 直接运行...
  
