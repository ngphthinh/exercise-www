use
    storedb;

CREATE TABLE books
(
    book_id  int PRIMARY KEY AUTO_INCREMENT,
    title    VARCHAR(255) NOT NULL,
    author   VARCHAR(255) NOT NULL,
    price    DOUBLE       NOT NULL,
    quantity INT          NOT NULL,
    image    VARCHAR(255)
);

insert into books (title, author, price, quantity, image)
values ('The Great Gatsby', 'F. Scott Fitzgerald', 10.99, 5, 'book1.jpg'),
       ('To Kill a Mockingbird', 'Harper Lee', 12.99, 3, 'book2.jpg'),
       ('1984', 'George Orwell', 9.99, 7, 'book3.jpg'),
       ('Pride and Prejudice', 'Jane Austen', 8.99, 4, 'book4.jpg'),
       ('The Catcher in the Rye', 'J.D. Salinger', 11.99, 6, 'book5.jpg'),
       ('The Hobbit', 'J.R.R. Tolkien', 14.99, 2, 'book6.jpg'),
       ('Moby Dick', 'Herman Melville', 13.99, 1, 'book1.jpg'),
       ('War and Peace', 'Leo Tolstoy', 15.99, 3, 'book2.jpg'),
       ('The Odyssey', 'Homer', 9.49, 5, 'book3.jpg'),
       ('Crime and Punishment', 'Fyodor Dostoevsky', 11.49, 4, 'book4.jpg');

select * from books;

select * from books where book_id = '2'

