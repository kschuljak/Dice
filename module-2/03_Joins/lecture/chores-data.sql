
DROP TABLE IF EXISTS person, task CASCADE;

CREATE TABLE person
(
    person_id int NOT NULL PRIMARY KEY,
    person_name varchar(20) NOT NULL
);

CREATE TABLE task
(
    task_id int NOT NULL PRIMARY KEY,
    person_id int NULL REFERENCES person (person_id),
    task_name varchar(30) NOT NULL
);

INSERT INTO person (person_id, person_name)
VALUES (1, 'Marte''')
     , (2, 'David')
     , (3, 'Katrina');

INSERT INTO task (task_id, person_id, task_name)
VALUES (13, null, 'mop')
     , (14, 2, 'dishes')
     , (15, 3, 'mow the lawn')
     , (16, null, 'change oil');
