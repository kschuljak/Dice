-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'.
-- Order the results from the highest movie count to the lowest.
-- (19 rows, the highest expected count is around 400).

SELECT COUNT(m.title) AS num_of_movies,
	g.genre_name
FROM movie AS m
JOIN movie_genre AS mg
	ON m.movie_id = mg.movie_id
JOIN genre AS g
	ON mg.genre_id = g.genre_id
GROUP BY g.genre_name
ORDER BY num_of_movies DESC;