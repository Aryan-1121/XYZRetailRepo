USE SHOPPINGBASKET;

SELECT * FROM item_details;
use wileyc256;

select * from share;

select * from customerdata;
set sql_safe_updates=0;
select * from customer;

create table customer(
userName varchar(255) primary key,
userPassword varchar(255));
drop table customer;

create database xyzretail;
use xyzretail;
drop table itemdetail;
select * from itemdetail;
desc itemscart;
drop table itemscart;

create table itemscart(
 cartid int primary key auto_increment, 
	itemId varchar(255),
	itemName varchar(255),
	unitPrice double,
	userName varchar (255),
	requiredQuantity int,
	salesTax double,
	totalCost double
);
desc itemscart;
select * from itemscart;
truncate itemscart;
insert into itemscart values(1,'B-101','BOOKS',250,'lakshmi',5,0,1250);
insert into itemscart values(2,'B-102','BOOKS',150,'aryan',2,0,300);
insert into itemscart values(3,'CS-102','COSMETICS',150,'aryan',2,12,336);
create table itemscart(cartId int primary key auto_increment,
itemId varchar(20), itemName varchar(20),requiredQuantity int, salesTax double,totalCost double, unitPrice double,userName varchar(20));
use shoppingbasket;
select * from customer;
insert into customer values("aryan","1234");

create table itemdetail(
ItemId varchar(10) primary Key,
ItemCategory varchar(20) ,
ItemName varchar(50) ,
ItemPrice double ,
AvailableQuantity int);
insert ignore into  itemDetail  values 
('B-101', "Books", "Harry Potter", 899, 25),
('B-102', "Books", "Panchtantra", 250, 100),
('B-103', "Books", "The Far Field", 499, 35),
('B-104', "Books", "9 Golden Pipes", 599, 50),
('B-105', "Books", "The Gypsy Goddess", 499, 70),


('CD-101', "CD", "90's Song", 200, 100),
('CD-102', "CD"  , "Modern Song", 250, 150),
('CD-103', "CD", "Hollywood Movies", 400, 100),
('CD-104', "CD", "BOllywood Movies", 400, 100),
('CD-105', "CD", "Hindi Songs", 200, 100),
('CD-106', "CD", "English Songs" , 200, 100),


('CS-101', "COSMETICS", "Lipstick", 350, 200),
('CS-102', "COSMETICS", "Mascara﻿ ", 499, 150),
('CS-103', "COSMETICS", "Nail paint", 150, 300),
('CS-104', "COSMETICS", "Highlighter", 299, 200),
('CS-105', "COSMETICS", "Eye liner", 399, 200) ;

desc itemDetail;
desc customer;