-- 切换数据库
use imooc;
-- 新建数据库
create database imooc;

-- 创建表
create table imooc_user(
    username varchar(20),
    age int,
    score float
);

-- 删除表
drop table if exists imooc_user;

-- 新建表
create table article(
    id int,
    title varchar(50),
    content text,
    `rank` int,
    price decimal(10, 2)
);
-- 查看表结构
desc article;

-- 创建带有约束的表
drop table if exists imooc_user;
create table imooc_user(
    id integer primary key,
    username varchar(20) not null,
    age int,
    score decimal(10, 2) default 0

);
desc imooc_user;

drop table if exists imooc_user;
create table imooc_user(
    username varchar(20),
    age int
);
desc imooc_user;

-- 添加字段ALTER
alter table imooc_user
add score float;
desc imooc_user;

-- 修改字段
alter table imooc.imooc_user
modify score decimal(10, 2);
desc imooc.imooc_user;

alter table imooc_user
modify username varchar(30);
desc imooc_user;

-- 删除字段
alter table imooc_user
drop score;
desc imooc.imooc_user;

-- 添加索引
alter table imooc_user
add index (username);

-- 添加索引并命名
alter table imooc_user
add index username_index (username);

-- 添加联合索引
alter table imooc_user
add index username_age_index(username, age);
desc imooc.imooc_user;

-- 查看表中索引
show index from imooc.imooc_user;

-- 删除索引
drop index username on imooc.imooc_user;
show index from imooc_user;

drop index username_age_index on imooc_user;
show index from imooc.imooc_user;

-- DROP

drop table if exists imooc_user;
create table imooc_user(
    username varchar(20),
    age int
);
alter table imooc_user
add index age_index(age);
desc imooc_user;

-- 删除数据库
drop database if exists imooc;

-- 删除表
drop table if exists imooc_user;

-- 清空表数据
insert into imooc.imooc_user(username, age)
values('hsy', 18);
select * from imooc_user;
truncate table imooc_user;
select * from imooc.imooc_user;

-- 删除表字段
alter table imooc_user
    drop age;
desc imooc_user;

-- 删除索引
alter table imooc_user
add index username_index(username);

alter table imooc_user
drop index username_index;

show index from imooc_user;

-- 创建、删除视图
create view imooc_user_view as
    select *
    from imooc_user;
;
select *
from imooc_user_view;

drop view imooc_user_view;