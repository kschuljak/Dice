-- IDEMPOTENT - should be able to run from start to end

DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;


CREATE TABLE artist
(
	artist_id INT NOT NULL PRIMARY KEY,
	artist_name VARCHAR(50) NOT NULL
);

CREATE TABLE art
(
	art_id SERIAL NOT NULL PRIMARY KEY,
	artist_id INT NOT NULL REFERENCES artist(artist_id),
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
	art_id INT NOT NULL REFERENCES art(art_id),
	customer_id INT NOT NULL REFERENCES customer(customer_id),
	purchase_date DATE NOT NULL,
	sales_price NUMERIC(10,2) NOT NULL CHECK( sales_price > 0),
	PRIMARY KEY (
		art_id,
		customer_id,
		purchase_date
	)
);


-- version 2 - no in-line references

DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;


CREATE TABLE artist
(
	artist_id INT NOT NULL,
	artist_name VARCHAR(50) NOT NULL
);

CREATE TABLE art
(
	art_id SERIAL NOT NULL,
	artist_id INT NOT NULL,
	art_name VARCHAR(200) NOT NULL,
	genre VARCHAR(15) NULL
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

-- 1st - CREATE ALL TABLES
-- 2nd - INSERT ALL DATA
-- 3rd - ADD FOREIGN KEY CONSTRAINTS
ALTER TABLE art
ADD CONSTRAINT FK_art_artist
FOREIGN KEY (artist_id)
REFERENCES artist(artist_id);

ALTER TABLE transaction
ADD CONSTRAINT FK_transation_art
FOREIGN KEY (art_id)
REFERENCES art(art_id);

ALTER TABLE transaction
ADD CONSTRAINT FK_transaction_customer
FOREIGN KEY (customer_id)
REFERENCES customer(customer_id);
