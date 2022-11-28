-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.


DELETE FROM movie_actor
WHERE movie_id = (
	SELECT movie_id
	FROM movie
	WHERE title = 'Avengers: Infinity War'
);
