
create table users(
	userid int unsigned not null auto_increment primary key,
	username varchar(20) not null unique,
	truename varchar(20) not null comment'����',
	passwd   varchar(20) not null comment'����',
	email    varchar(30) not null comment'�ʼ�',
	phone    varchar(10) not null comment'�ֻ�',
	address   varchar(50) not null  comment'��ַ',
	postcode  char(6) not null  comment'�ʱ�',
	grade     tinyint not null default 1  comment'�û�����'
)engine=innodb default charset=utf8;

insert into users values(null,'liushifu','����ΰ','123','334455@qq.com','1234567890','����С��������Ԫ����¥123��','10001',1);
-- ����Ա������

create table goods(
   goodsId int unsigned not null auto_increment primary key,
   goodsName varchar(20) not null comment '��������',
   goodsIntro varchar(500) not null comment '����',
   goodsPrice decimal(5,2) comment '�۸�',
   goodsNum  smallint unsigned comment '����',
   publisher varchar(40) comment '������',
   photo   varchar(50) comment '��Ƭ',
   `type`  varchar(10) comment '����'
)engine=innodb default charset=utf8;
insert into goods values(null,'�ڰ�ɭ��','����һ����Ƭ',59.99,1,'��ۼκ̳�Ʒ','01.jpg','��۵�Ӱ');
insert into goods values(null,'��2','����һ����Ƭ',66.88,1,'��ۼκ̳�Ʒ','02.jpg','��۵�Ӱ');
insert into goods values(null,'��Ů�˹�','����һ����Ƭ',30.88,1,'��ۼκ̳�Ʒ','03.jpg','��۵�Ӱ');
insert into goods values(null,'��������','����һ����Ƭ',59.88,1,'��ۼκ̳�Ʒ','04.jpg','��۵�Ӱ');
insert into goods values(null,'���ư�','����һ����Ƭ',55.88,1,'��ۼκ̳�Ʒ','02.jpg','��۵�Ӱ');
insert into goods values(null,'�ӱ��¼�','����һ����Ƭ',66.88,1,'��ۼκ̳�Ʒ','02.jpg','��۵�Ӱ');