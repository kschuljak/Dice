BEGIN TRANSACTION;

DROP TABLE IF EXISTS park_state, park, city, state CASCADE;

CREATE TABLE state (
	state_abbreviation char(2) NOT NULL,
	state_name varchar(50) NOT NULL,
	population int NOT NULL,
	area int NOT NULL,
	capital int /*NOT*/ NULL, --temporarily nullable because it's a foreign key to city.city_id
	sales_tax numeric(5,3) NOT NULL,
	state_nickname varchar(100) NULL,
	census_region varchar(10) NULL,
	CONSTRAINT PK_state PRIMARY KEY(state_abbreviation),
	CONSTRAINT UQ_state_name UNIQUE(state_name),
    CONSTRAINT UQ_state_nickname UNIQUE(state_nickname),
	CONSTRAINT CHK_census_region CHECK (census_region IS NULL OR census_region IN ('Northeast', 'South', 'Midwest', 'West'))
);

CREATE TABLE city (
	city_id serial,
	city_name varchar(50) NOT NULL,
	state_abbreviation char(2) NOT NULL,
	population int NOT NULL CONSTRAINT DF_population DEFAULT(0),
	area numeric(5,1) NOT NULL,
	CONSTRAINT PK_city PRIMARY KEY(city_id),
	CONSTRAINT FK_city_state FOREIGN KEY(state_abbreviation) REFERENCES state(state_abbreviation)
);

CREATE TABLE park (
	park_id serial,
	park_name varchar(50) NOT NULL,
	date_established date NOT NULL,
	area numeric(6,1) NOT NULL,
	has_camping boolean NOT NULL,
	CONSTRAINT PK_park PRIMARY KEY(park_id),
	CONSTRAINT UQ_park_name UNIQUE(park_name)
);

CREATE TABLE park_state (
	park_id int NOT NULL,
	state_abbreviation char(2) NOT NULL,
	CONSTRAINT PK_park_state PRIMARY KEY(park_id, state_abbreviation),
	CONSTRAINT FK_park_state_park FOREIGN KEY(park_id) REFERENCES park(park_id),
	CONSTRAINT FK_park_state_state FOREIGN KEY(state_abbreviation) REFERENCES state(state_abbreviation)
);

INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax)
VALUES ('AA', 'State A', 0, 0, 0),
       ('BB', 'State B', 0, 0, 0),
       ('CC', 'State C', 0, 0, 0);

INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('City 1', 'AA', 11, 111), -- city_id will be 1 due to serial
       ('City 2', 'BB', 22, 222), -- city_id will be 2 due to serial
       ('City 3', 'CC', 33, 333), -- city_id will be 3 due to serial
       -- One city that isn't a capital so it can be deleted by tests.
       ('City 4', 'AA', 44, 444); -- city_id will be 4 due to serial

UPDATE state SET capital = 1 WHERE state_abbreviation = 'AA';
UPDATE state SET capital = 2 WHERE state_abbreviation = 'BB';
UPDATE state SET capital = 3 WHERE state_abbreviation = 'CC';

INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('Park 1', '1800-01-02', 100, true),  -- park_id will be 1 due to serial
       ('Park 2', '1900-12-31', 200, false), -- park_id will be 2 due to serial
       ('Park 3', '2000-06-15', 300, false); -- park_id will be 3 due to serial

INSERT INTO park_state (park_id, state_abbreviation)
VALUES (1, 'AA'),
       (2, 'BB'),
       (3, 'CC'),
       (3, 'AA'); -- Park 3 is in 2 states.

ALTER TABLE state ADD CONSTRAINT FK_state_city FOREIGN KEY(capital) REFERENCES city(city_id);
ALTER TABLE state ALTER COLUMN capital SET NOT NULL;

COMMIT;