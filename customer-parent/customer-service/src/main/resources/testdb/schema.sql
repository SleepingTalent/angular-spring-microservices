drop table CUSTOMERS if exists;

create table CUSTOMERS (
ID bigint identity primary key,  
TITLE varchar(100) not null, 
FIRSTNAME varchar(100) not null, 
LASTNAME varchar(100) not null,
DATE_OF_BIRTH varchar(100) not null, 
DESCRIPTION varchar(100) not null 
);

