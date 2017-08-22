Create Table Category(
id number(4) ,
name varchar2(50),
description varchar2(255),
image_url varchar2(50),
is_active number(1),
constraint pk_category_id Primary Key(id)
);

Insert into Category (name,description,image_url,is_active) values ('Television','This is Television','cat_89.jpg',0);
Insert into Category (name,description,image_url,is_active) values ('Laptop','This is Laptop','cat_90.jpg',0);
Insert into Category (name,description,image_url,is_active) values ('Mobile','This is Mobile','cat_91.jpg',0);

Create Table user_detail(

id number(4),
first_name varchar2(50),
last_name varchar2(50),
role varchar2(50),
enable number(1),
password varchar2(16),
email varchar2(50),
contact_number varchar2(15),

constraint pk_user_id Primary Key(id)
);

Insert into user_detail (first_name,last_name,role,enable,password,email,contact_number) 
values ('Virat','Kohli','ADMIN',0,'admin','vk@gmail.com','8888888888');

Insert into user_detail (first_name,last_name,role,enable,password,email,contact_number) 
values ('Rabindra','Jadeja','SUPPLIER',0,'12345','rj@gmail.com','999999999');

Insert into user_detail (first_name,last_name,role,enable,password,email,contact_number) 
values ('Ravichandra','Ashwin','SUPPLIER',0,'12345','ra@gmail.com','7777777777');

Create Table Product(

id number(4),
code varchar2(50),
name varchar2(50),
brand varchar2(50),
description varchar2(1000),
unit_price Decimal(16,2),
quantity number(4),
is_active number(1),
category_id number(4),
supplier_id number(4),
purchases INT default 0,
views INT default 0,
constraint pk_user_id Primary Key(id),
constraint fk_product_category_id Foreign Key(category_id) references category(id),
constraint fk_product_supplier_id Foreign Key(supplier_id) references user_detail(id)
);

Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('ASDFGH','Micromax Evok Dual Note','Micromax','With powerful features, the Micromax Evok Dual Note is engineered to impress.','9999.00',10,0,3,2);


Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('ASDFGI','Infinix Note 4','Infinix','With the Infinix Note 4, you can explore new possibilities and take charge of your life, thanks to its 14.47 cm (5.7) IPS LCD display and its XOS 2.2.','8999.00',10,0,3,2);


Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('ASDFGJ','Lenevo K5 Note','Lenevo','If you use your phone mainly for watching videos or for gaming, and want an immersive experience, the Lenovo Vibe K5 Note phone is for you.','10499.00',5,0,3,3);


Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('QWERTY','Lenevo Ideapad','Lenevo','Laptop, Battery, Power Adaptor, User Guide, Warranty Documents','45990.00',8,0,2,3);

Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('QWERTX','HP Core i3 6th Gen','Full-size Textured Island Style Keyboard with Numeric Keypad','27490.00',9,0,2,2);

Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('QWERTZ','Apple Macbook Air Core i5','Apple','One of the best laptop available in this price range','59990.00',4,0,2,3);

Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('QWERTZ','Apple Macbook Air Core i5','Apple','One of the best laptop available in this price range','59990.00',4,0,2,3);

Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('QWERTZ','Apple Macbook Air Core i5','Apple','One of the best laptop available in this price range','59990.00',4,0,2,3);

Insert into Product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
values('ZXCVBN','Micromax 108','Micromax','To avail 2 Years Extended Warranty Offer-Extended Warranty Registration is mandatory within 30 days of Purchase date only','25990.00',4,0,1,3);