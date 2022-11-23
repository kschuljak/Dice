-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)

SELECT title
	, release_date
FROM movie AS m
INNER JOIN movie_actor AS ma
	ON ma.movie_id = m.movie_id
INNER JOIN person AS p
	ON p.person_id = ma.actor_id
WHERE p.person_name = 'Tom Hanks'
ORDER BY release_date;

