-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)

SELECT DISTINCT p.person_name
FROM person AS p
JOIN movie_actor AS ma
	ON p.person_id = ma.actor_id
JOIN movie AS m
	ON ma.movie_id = m.movie_id
JOIN collection AS c
	ON m.collection_id = c.collection_id
WHERE c.collection_name = 'Back to the Future Collection'
ORDER BY p.person_name;
