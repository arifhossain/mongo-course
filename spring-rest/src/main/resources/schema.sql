--create book table
CREATE TABLE book(
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_name VARCHAR(50),
    author VARCHAR(50)
);

--create exchange_value table
CREATE TABLE exchange_value(
    id INT PRIMARY KEY AUTO_INCREMENT,
    currency_from VARCHAR(50),
    currency_to VARCHAR(50),
    conversion_multiple INT,
    port INT
);