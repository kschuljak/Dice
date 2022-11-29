

DROP TABLE IF EXISTS artist, art, customer, transaction CASCADE;


-- create tables
CREATE TABLE artist
(
    artist_id INT NOT NULL PRIMARY KEY,
    artist_name VARCHAR(50) NOT NULL
);

CREATE TABLE art
(
    art_id SERIAL NOT NULL PRIMARY KEY, -- SERIAL is an autonumber int
    artist_id INT NOT NULL,
    art_name VARCHAR(200) NOT NULL,
    genre VARCHAR(15) NULL
);

CREATE TABLE customer
(
    customer_id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    street VARCHAR(100) NULL,
    city VARCHAR(100) NULL,
    state CHAR(2) NULL,
    postal_code VARCHAR(10) NULL,
    phone VARCHAR(10) NULL
);

CREATE TABLE transaction
(
    art_id INT NOT NULL,
    customer_id INT NOT NULL,
    purchase_date DATE NOT NULL,
    sales_price NUMERIC(10,2) NOT NULL CHECK( sales_price > 0),
    PRIMARY KEY (
        art_id,
        customer_id,
        purchase_date
    )
);

-- INSERT ALL DATA


-- ADD FOREIGN KEY CONSTRAINTS

ALTER TABLE art
ADD CONSTRAINT FK_art_artist
FOREIGN KEY (artist_id)
REFERENCES artist(artist_id);

ALTER TABLE transaction
ADD CONSTRAINT FK_transaction_art
FOREIGN KEY (art_id)
REFERENCES art(art_id);

ALTER TABLE transaction
ADD CONSTRAINT FK_transaction_customer
FOREIGN KEY (customer_id)
REFERENCES customer(customer_id);


