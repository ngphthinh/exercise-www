create database storedb;

use storedb;
create table accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(50),
    last_name varchar(50),
    password varchar(50),
    email varchar(50),
    date_of_birth date,
    gender varchar(10)
);

select * from accounts