-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

SELECT m.title
FROM movie AS m
JOIN person AS p
	ON m.director_id = p.person_id
WHERE p.person_name = 'James Cameron'
ORDER BY m.title;