## deep社区

## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)    
[es](https://elasticsearch.cn/explore)  
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)   

## 工具
[Git](https://git-scm.com/download)    
[Visual Paradigm](https://www.visual-paradigm.com) 

## 脚本

```mysql
CREATE TABLE USER_1
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT,
    BIO VARCHAR(256)
);
CREATE TABLE `question` (
`id`  int NOT NULL AUTO_INCREMENT ,
`title`  varchar(50) NULL ,
`description`  text NULL ,
`gmt_create`  bigint NULL ,
`gmt_modified`  bigint NULL ,
`creator`  int NULL ,
`comment_count`  int NULL DEFAULT 0 COMMENT '评论数' ,
`view_count`  int NULL DEFAULT 0 COMMENT '浏览数' ,
`like_count`  int NULL DEFAULT 0 COMMENT '点赞数' ,
`tag`  varchar(256) NULL ,
PRIMARY KEY (`id`)
)
;

```

```bash
mvn flyway:migrate
``` 