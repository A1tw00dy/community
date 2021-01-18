## 旅游社区

##资料
[spring文档](https://spring.io/guides)

[springboot文档](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-configure-datasource)

[实现github登录文档](https://docs.github.com/cn/free-pro-team@latest/developers/apps/building-oauth-apps)

[okhttp文档](https://square.github.io/okhttp/)

[maven仓库](https://mvnrepository.com/)

[h2数据库](http://www.h2database.com/html/main.html)

[springboot集成mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)


## git地址
https://github.com/A1tw00dy/community

##脚本
```sql
create table USER
(
	ID INT auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);
```