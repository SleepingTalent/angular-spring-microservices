drop table CUSTOMERS if exists;

create table CUSTOMERS (ID bigint identity primary key, FIRSTNAME varchar(100) not null, LASTNAME varchar(100) not null);

