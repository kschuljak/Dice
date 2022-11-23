-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

SELECT m.title
	, p.person_name
FROM movie AS m
JOIN movie_actor AS ma
	ON m.movie_id = ma.movie_id
JOIN person AS p
	ON ma.actor_id = p.person_id
WHERE p.person_id = (
	SELECT p.person_id
	FROM person AS p
	WHERE m.director_id = p.person_id
)
ORDER BY m.title;