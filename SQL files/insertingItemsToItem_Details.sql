use shoppingbasket;


desc item_Details;

insert ignore into  item_Details  values 
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



delete from item_Details;

drop table item_Details;

select * from item_Details;
