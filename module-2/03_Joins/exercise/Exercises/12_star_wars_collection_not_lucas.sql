-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)


SELECT m.title
FROM movie AS m
JOIN collection AS c
	ON c.collection_id = m.collection_id
JOIN person AS p
	ON m.director_id = p.person_id
WHERE c.collection_name = 'Star Wars Collection'
GROUP BY m.title, p.person_name
HAVING p.person_name != 'George Lucas'
ORDER BY m.title;