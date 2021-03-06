## 旅游社区

## 资料

[bootstarp文档](https://v3.bootcss.com/)

[spring文档](https://spring.io/guides)

[springboot文档](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-configure-datasource)

[实现github登录文档](https://docs.github.com/cn/free-pro-team@latest/developers/apps/building-oauth-apps)

[okhttp文档](https://square.github.io/okhttp/)

[maven仓库](https://mvnrepository.com/)

[h2数据库](http://www.h2database.com/html/main.html)

[springboot集成mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[flyway文档](https://flywaydb.org/)

[lombok文档](https://projectlombok.org/)

[moment文档(js日期处理类库)](http://momentjs.cn/)

## git地址

https://github.com/A1tw00dy/community

## 脚本

```sql
create table USER
(
	ID INT auto_increment PRIMARY KEY NOT NULL,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
);
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```