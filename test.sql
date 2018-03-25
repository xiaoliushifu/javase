
create table users(
	userid int unsigned not null auto_increment primary key,
	username varchar(20) not null unique,
	truename varchar(20) not null comment'真名',
	passwd   varchar(20) not null comment'密码',
	email    varchar(30) not null comment'邮件',
	phone    varchar(10) not null comment'手机',
	address   varchar(50) not null  comment'地址',
	postcode  char(6) not null  comment'邮编',
	grade     tinyint not null default 1  comment'用户级别'
)engine=innodb default charset=utf8;

insert into users values(null,'liushifu','刘明伟','123','334455@qq.com','1234567890','星星小区嘻嘻单元哈哈楼123号','10001',1);
-- 管理员表暂无

create table goods(
   goodsId int unsigned not null auto_increment primary key,
   goodsName varchar(20) not null comment '货物名称',
   goodsIntro varchar(500) not null comment '介绍',
   goodsPrice decimal(5,2) comment '价格',
   goodsNum  smallint unsigned comment '数量',
   publisher varchar(40) comment '发行商',
   photo   varchar(50) comment '照片',
   `type`  varchar(10) comment '类型'
)engine=innodb default charset=utf8;
insert into goods values(null,'黑白森林','这是一部好片',59.99,1,'香港嘉禾出品','01.jpg','香港电影');
insert into goods values(null,'金鸡2','这是一部好片',66.88,1,'香港嘉禾出品','02.jpg','香港电影');
insert into goods values(null,'靓女菜馆','这是一部好片',30.88,1,'香港嘉禾出品','03.jpg','香港电影');
insert into goods values(null,'布衣神相','这是一部好片',59.88,1,'香港嘉禾出品','04.jpg','香港电影');
insert into goods values(null,'风云帮','这是一部好片',55.88,1,'香港嘉禾出品','02.jpg','香港电影');
insert into goods values(null,'河北事件','这是一部好片',66.88,1,'香港嘉禾出品','02.jpg','香港电影');


-- 订单表

CREATE TABLE `orders` (
  `ordersId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(10) unsigned NOT NULL,
  `orderDate` datetime NOT NULL DEFAULT '2018-01-01 15:00:00',
  `payMode` varchar(10) NOT NULL DEFAULT '货到付款' COMMENT '付款模式：货到付款  支付宝付款',
  `isPayed` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否付款 1未付款  2已付款',
  `totalPrice` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '总价',
  PRIMARY KEY (`ordersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 订单详情表
create  table orderDetail(
	ordersId int unsigned not null comment '关联订单id',
	goodsId int unsigned not null comment '关联商品id',
	nums tinyint comment '商品数量'
)engine=innodb charset=utf8;


