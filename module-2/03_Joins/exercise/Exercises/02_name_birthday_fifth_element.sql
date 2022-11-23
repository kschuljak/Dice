-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)

SELECT p.person_name
	, p.birthday
FROM person AS p
INNER JOIN movie_actor AS ma
	ON ma.actor_id = p.person_id
INNER JOIN movie AS m
	ON m.movie_id = ma.movie_id
WHERE m.title = 'The Fifth Element'
ORDER BY p.person_name;