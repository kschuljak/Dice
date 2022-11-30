-- create tables
-- populate with minimum: 4 events, 3 groups, 8 members
-- each event has at least one member, each group has at least two members

DROP TABLE IF EXISTS group_member, event_member, event_table, group_table, member_table CASCADE;


CREATE TABLE member_table
(
	member_number SERIAL NOT NULL PRIMARY KEY,
	last_name VARCHAR(50) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	phone VARCHAR(10) NULL,
	birthday DATE NOT NULL,
	wants_reminder_emails BOOLEAN NOT NULL
);

CREATE TABLE group_table
(
	group_number SERIAL NOT NULL PRIMARY KEY,
	group_name VARCHAR(50)
);

CREATE TABLE event_table
(
	event_number SERIAL NOT NULL PRIMARY KEY,
	event_name VARCHAR(50) NOT NULL,
	start_date_time TIMESTAMP NOT NULL,
	duration VARCHAR(200) NULL,
	group_number INT NOT NULL REFERENCES group_table(group_number)
);

CREATE TABLE event_member
(
	event_number INT NOT NULL REFERENCES event_table(event_number),
	member_number INT NOT NULL REFERENCES member_table(member_number),
	PRIMARY KEY (
		event_number,
		member_number
	)
);

CREATE TABLE group_member
(
	group_number INT NOT NULL REFERENCES group_table(group_number),
	member_number INT NOT NULL REFERENCES member_table(member_number),
	PRIMARY KEY (
		group_number,
		member_number
	)
);

-- adding members to member_table
INSERT INTO member_table
(
	last_name,
	first_name,
	email,
	phone,
	birthday,
	wants_reminder_emails
)
VALUES
(
	'Ketchum',
	'Ash',
	'gottacatchemall@pallettown.com',
	'5555555555',
	DATE '1984-05-22',
	FALSE
);



INSERT INTO member_table(last_name, first_name, email, phone, birthday, wants_reminder_emails)
VALUES	('Harrison', 'Brock', 'docbrock@kantoclinic.com', '1234567890', DATE '1997-04-21', TRUE),
		('Mizuyawa', 'Misty', 'misty@cerulean.gym', '5556667777', DATE '1982-01-27', FALSE),
		('Oak', 'Samuel', 'professoroak@oaklab.edu', '3215556556', DATE '1947-05-12', FALSE),
		('Oak', 'Gary', 'gary@oaklab.edu', '3215556556', DATE '1984-04-06', TRUE),
		('Oak', 'Daisy', 'daisyoak@oaklab.edu', '3215557757', DATE '1981-02-03', TRUE),
		('Ketchum', 'Delia', 'dketchum@pallettown.com', '5555555556', DATE '1968-01-23', FALSE),
		('Yukiko', 'Leaf', 'lyukiko@pallettown.com', '1239894555', DATE '1984-09-23', TRUE);
		
SELECT *
FROM member_table;


-- populating group table
INSERT INTO group_table(group_name)
VALUES 	('Pallet Town Crew'),
		('Oak Lab'),
		('Battle Buddies!');
		
SELECT *
FROM group_table;
		
-- populating event table
INSERT INTO event_table
(
	event_name,
	start_date_time,
	duration,
	group_number
)
VALUES
(
	'Friday Night Level-Up Battles!',
	TIMESTAMP '2022-12-02 17:00:00',
	120,
	(SELECT group_number FROM group_table WHERE group_name = 'Battle Buddies!')
),
(
	'Friday Night Level-Up Battles!',
	TIMESTAMP '2022-12-09 17:00:00',
	120,
	(SELECT group_number FROM group_table WHERE group_name = 'Battle Buddies!')
),
(
	'Introductions & Updates',
	TIMESTAMP '2022-11-30 12:30:00',
	30,
	(SELECT group_number FROM group_table WHERE group_name = 'Oak Lab')
),
(
	'Local Flavors - Tastes of Pallet Town',
	TIMESTAMP '2023-01-01 13:15:00',
	150,
	(SELECT group_number FROM group_table WHERE group_name = 'Pallet Town Crew')
);

SELECT *
FROM event_table;

-- populate group_member
INSERT INTO group_member(group_number, member_number)
VALUES(
	(SELECT group_number FROM group_table WHERE group_name = 'Pallet Town Crew'),
	(SELECT member_number FROM member_table WHERE first_name = 'Ash')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Pallet Town Crew'),
	(SELECT member_number FROM member_table WHERE first_name = 'Leaf')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Battle Buddies!'),
	(SELECT member_number FROM member_table WHERE first_name = 'Ash')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Battle Buddies!'),
	(SELECT member_number FROM member_table WHERE first_name = 'Misty')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Battle Buddies!'),
	(SELECT member_number FROM member_table WHERE first_name = 'Brock')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Oak Lab'),
	(SELECT member_number FROM member_table WHERE first_name = 'Samuel')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Oak Lab'),
	(SELECT member_number FROM member_table WHERE first_name = 'Gary')
),
(
	(SELECT group_number FROM group_table WHERE group_name = 'Oak Lab'),
	(SELECT member_number FROM member_table WHERE first_name = 'Daisy')
);

SELECT *
FROM group_member;

-- populate event_member
INSERT INTO event_member(event_number, member_number)
VALUES(
	(SELECT event_number FROM event_table WHERE event_name LIKE 'Friday Night%' AND start_date_time = TIMESTAMP '2022-12-02 17:00:00'),
	(SELECT member_number FROM member_table WHERE first_name = 'Ash')
),
(
	(SELECT event_number FROM event_table WHERE event_name LIKE 'Friday Night%' AND start_date_time = TIMESTAMP '2022-12-09 17:00:00'),
	(SELECT member_number FROM member_table WHERE first_name = 'Ash')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Introductions & Updates'),
	(SELECT member_number FROM member_table WHERE first_name = 'Ash')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Introductions & Updates'),
	(SELECT member_number FROM member_table WHERE first_name = 'Samuel')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Introductions & Updates'),
	(SELECT member_number FROM member_table WHERE first_name = 'Daisy')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Introductions & Updates'),
	(SELECT member_number FROM member_table WHERE first_name = 'Gary')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Local Flavors - Tastes of Pallet Town'),
	(SELECT member_number FROM member_table WHERE first_name = 'Samuel')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Local Flavors - Tastes of Pallet Town'),
	(SELECT member_number FROM member_table WHERE first_name = 'Brock')
),
(
	(SELECT event_number FROM event_table WHERE event_name = 'Local Flavors - Tastes of Pallet Town'),
	(SELECT member_number FROM member_table WHERE first_name = 'Misty')
);

SELECT *
FROM event_member;

-- checks
SELECT * FROM member_table;
SELECT * FROM event_table;
SELECT * FROM group_table;
SELECT * FROM event_member;
SELECT * FROM group_member;