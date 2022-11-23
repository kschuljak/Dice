-- 4. The titles and taglines of all the movies that are in the Fantasy genre. 
-- Order the results by title (A-Z).
-- (81 rows)

SELECT m.title
	, m.tagline
FROM movie AS m
INNER JOIN movie_genre AS mg
	ON mg.movie_id = m.movie_id
INNER JOIN genre AS g
	ON g.genre_id = mg.genre_id
WHERE g.genre_name ILIKE 'fantasy'
ORDER BY m.title;