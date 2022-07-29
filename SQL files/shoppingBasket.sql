create database if not exists ShoppingBasket;

use ShoppingBasket;

SET sql_safe_updates=0;

-- itemDetails 



create table if not exists 
item_details(
Item_Id varchar(10) primary key , 
Item_Category varchar(20) not null,
Item_Name varchar(50) not null,
Item_Price double not null, 
Available_Quantity int 
);

drop table item_Details;
desc item_details;



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

    transactionId int primary key,
    User_Name varchar(30),
    transaction_Date date,
    transaction_Time time,
    
    constraint user_key foreign key(User_Name)
    references customer (User_Name) on delete set null on update restrict
	
);


drop table transactionTable;







--   	ORDER TABLE 


create table if not exists Orders(
	transactionId int references transactionTable(transactionId),
	User_Name varchar(30) references customer(user_Name),
    purchased_Quantity int
);
    
    
    

