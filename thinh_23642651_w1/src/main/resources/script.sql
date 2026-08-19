create  database demo_servlet;
use demo_servlet;

create table Users(
                      id int primary key IDENTITY ,
                      firstname varchar(50),
                      lastname varchar(50),
                      picfile varchar(50)
)