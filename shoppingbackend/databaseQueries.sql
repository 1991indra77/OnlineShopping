Create Table Category(
id number(4) ,
name varchar2(50),
description varchar2(255),
image_url varchar2(50),
is_active number(1),
constraint pk_category_id Primary Key(id)
);

Insert into Category (name,description,image_url,is_active) values ("Television","This is Television","cat_89.jpg",0);