BEGIN TRANSACTION;

DROP TABLE IF EXISTS artist, art, customer, transaction CASCADE;


-- create tables
CREATE TABLE artist
(
    artist_id INT NOT NULL,
    artist_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (artist_id)
);

CREATE TABLE art
(
    art_id SERIAL NOT NULL, -- SERIAL is an autonumber int
    artist_id INT NOT NULL REFERENCES artist(artist_id),
    art_name VARCHAR(200) NOT NULL,
    genre VARCHAR(15) NULL,
    PRIMARY KEY (art_id)
);

CREATE TABLE customer
(
    customer_id SERIAL NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    street VARCHAR(100) NULL,
    city VARCHAR(100) NULL,
    state CHAR(2) NULL,
    postal_code VARCHAR(10) NULL,
    phone VARCHAR(10) NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE transaction
(
    art_id INT NOT NULL REFERENCES art (art_id),
    customer_id INT NOT NULL REFERENCES customer(customer_id),
    purchase_date DATE NOT NULL,
    sales_price NUMERIC(10,2) NOT NULL CHECK( sales_price > 0),
    PRIMARY KEY (
        art_id,
        customer_id,
        purchase_date
    )
);


COMMIT TRANSACTION
;
