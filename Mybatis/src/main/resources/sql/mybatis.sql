create database `imooc` character set "utf8" collate "utf8_general_ci";

use `imooc`;
use mysql;
show tables;

drop table if exists imooc_user;
create table imooc_user
(
	id int primary key auto_increment,
	username varchar(20),
	age int,
	score int
);

insert into imooc_user(id, username, age, score) 
values
(1, 'peter', 18, 100),
(2, 'pedro', 24, 200),
(3, 'jerry', 28, 500),
(4, 'mike', 12, 300),
(5, 'tom', 27, 1000);

show tables;

select id,
	username,
	age,
	score
from imooc_user;

