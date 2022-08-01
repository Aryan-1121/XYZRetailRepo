create database if not exists ShoppingBasket;
DROP DATABASE shoppingbasket;
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





    -- 			ITEM CART
    
    
Create table if not exists ItemsCart(
	itemId varchar(10),
    User_Name varchar(30) references customer(User_Name),
--     transactionId int references transactionTable(transactionId),
	requiredQuantity int not NULL,
	tax double,
	totalCost double,
    
	constraint itemFK foreign key(itemId) references Item_Details(Item_Id)
); 


delete from ItemsCart;
drop table ItemsCart;


select * from ItemsCart;
