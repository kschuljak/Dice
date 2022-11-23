-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)

SELECT p.person_name
	, m.title
FROM person AS p
INNER JOIN movie_actor AS ma
	ON ma.actor_id = p.person_id
INNER JOIN movie AS m
	ON m.movie_id = ma.movie_id
WHERE p.person_name ILIKE '% Jones'
ORDER BY p.person_name
	, m.title;
