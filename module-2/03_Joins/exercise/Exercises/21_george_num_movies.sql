-- 21. For every person in the person table with the first name of "George",
-- list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies.
-- Display the names in alphabetical order. 
-- (59 rows)


SELECT p.person_name
	, COUNT(m.title) AS num_of_movies
FROM movie AS m
JOIN movie_actor AS ma
	ON m.movie_id = ma.movie_id
RIGHT OUTER JOIN person AS p
	ON p.person_id = ma.actor_id
WHERE p.person_name ILIKE 'george %'
GROUP BY p.person_name, p.birthday;