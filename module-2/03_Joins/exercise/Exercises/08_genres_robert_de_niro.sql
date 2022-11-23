-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)

SELECT DISTINCT g.genre_name
FROM genre AS g
JOIN movie_genre AS mg
	ON g.genre_id = mg.genre_id
JOIN movie AS m
	ON m.movie_id = mg.movie_id
JOIN movie_actor AS ma
	ON ma.movie_id = m.movie_id
JOIN person AS p
	ON ma.actor_id = p.person_id
WHERE p.person_name = 'Robert De Niro'
GROUP BY g.genre_name
	, m.release_date
HAVING DATE_PART('year', m.release_date) >= 2010;


