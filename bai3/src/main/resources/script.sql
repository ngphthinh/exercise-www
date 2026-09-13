use storedb;

drop table if exists Product;
create table Product
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    model       varchar(50),
    description varchar(255),
    price       float,
    quantity    int,
    img         varchar(255)
);


Insert into Product(model, description, price, quantity, img)
VALUES ('Iphone 18', 'The latest iPhone model with advanced features', 999.99, 50, 'images/iphone18.png'),
       ('Samsung Galaxy S23', 'The latest Samsung Galaxy model with cutting-edge technology', 899.99, 30,
        'images/s23.png'),
       ('Google Pixel 7', 'The latest Google Pixel model with advanced camera features', 799.99, 20,
        'images/gp7.png'),
       ('OnePlus 11', 'The latest OnePlus model with high-performance features', 699.99, 40, 'images/op11.png')
;
select *
 from Product;
