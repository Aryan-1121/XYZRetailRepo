use ShoppingBasket;

set sql_safe_updates=0;

select * from itemscart;



-- 	TRANSACTION


select transactionId from transactionTable;
create table if not exists transactionTable
(

    transactionId int auto_increment primary key,
    User_Name varchar(30),
    transaction_Date date,
    transaction_Time time,
    
    constraint user_key foreign key(User_Name)
    references customer (User_Name) on delete set null on update restrict
	
);

select max(transactionId )from transactionTable;
alter table transactionTable 
 auto_increment=10;
drop table transactionTable;

select * from transactionTable;

delete from transactiontable;

--   	ORDER TABLE 


create table if not exists Orders(
	transactionId int references transactionTable(transactionId),
	itemId varchar(10) references ItemsCart(itemId),
    purchased_Quantity int references ItemsCart(requiredQuantity)
);
    
    select * from Orders;
    
    delete from orders;
    drop table orders;


insert ignore into orders 
select t.transactionId , i.itemId, requiredQuantity
from itemsCart i, transactionTable t
where (transactionId=18 )and t.User_Name=i.User_Name;




















