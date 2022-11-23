-- NO JOIN
SELECT *
FROM person;

SELECT * 
FROM task;


-- INNER JOIN

SELECT *
FROM person
INNER JOIN task 
    ON person.person_id = task.person_id;

SELECT *
FROM task AS t 
INNER JOIN person AS p
    ON p.person_id = t.person_id;


-- LEFT JOIN
SELECT *
FROM person as p
LEFT OUTER JOIN task  as t
    ON p.person_id = t.person_id;



-- RIGHT JOIN
SELECT *
FROM person as p
RIGHT OUTER JOIN task  as t
    ON p.person_id = t.person_id;

-- FULL JOIN

SELECT *
FROM person as p
FULL OUTER JOIN task  as t
    ON p.person_id = t.person_id;


-- CROSS JOIN
-- Cartesian product
-- all possible combinations
-- do not specify column to join on
SELECT p.person_name
    , t.task_name
FROM person as p
CROSS JOIN task  as t;