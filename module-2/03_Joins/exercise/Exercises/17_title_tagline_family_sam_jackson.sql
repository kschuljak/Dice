-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)

SELECT m.title
	, m.tagline
FROM movie AS m
JOIN movie_genre AS mg
	ON m.movie_id = mg.movie_id
JOIN genre AS g
	ON mg.genre_id = g.genre_id
JOIN movie_actor AS ma
	ON m.movie_id = ma.movie_id
JOIN person AS p
	ON ma.actor_id = p.person_id
WHERE g.genre_name = 'Family'
GROUP BY m.title, m.tagline, p.person_name
HAVING p.person_name = 'Samuel L. Jackson'
ORDER BY m.title;