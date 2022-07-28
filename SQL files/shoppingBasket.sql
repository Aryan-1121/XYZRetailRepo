create database if not exists ShoppingBasket;

use ShoppingBasket;


-- BASKET

drop table basket;

create table if not exists 
basket(
Item_Id varchar(5) primary key , 
Item_Category varchar(20),
Item_Name varchar(20) not null,
Item_Price double not null, 
Available_Quantity int 
);



-- CUSTOMER 

create table if not exists customer
(
User_Name varchar(30) primary key,
User_Password varchar(30) not null
);

select * from customer;
drop table customer;


-- 	TRANSACTION

create table if not exists transactionTable
(

	item_Id varchar(5),
    purchase_Date date,
    purchase_Time time,
    item_quantity int,
    User_Name varchar(30),
    constraint item_key foreign key(Item_Id)
    references basket (item_Id) on delete set null on update restrict,
	
    constraint user_key foreign key(User_Name)
    references customer (User_Name) on delete set null on update restrict
	
);


drop table transactionTable;
