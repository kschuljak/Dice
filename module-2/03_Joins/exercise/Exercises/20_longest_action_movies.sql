-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. 
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT m.title
	, m.length_minutes
	, m.release_date
FROM movie AS m
JOIN movie_genre AS mg
	ON m.movie_id = mg.movie_id
JOIN genre AS g
	ON mg.genre_id = g.genre_id
WHERE g.genre_name = 'Action'
ORDER BY m.length_minutes DESC
	, m.release_date DESC
LIMIT 5;