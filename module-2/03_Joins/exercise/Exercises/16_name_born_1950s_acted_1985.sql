-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)

SELECT p.person_name
	, p.birthday
FROM person AS p
JOIN movie_actor AS ma
	ON p.person_id = ma.actor_id
JOIN movie AS m
	ON ma.movie_id = m.movie_id
WHERE DATE_PART('year',m.release_date) = 1985
GROUP BY p.person_name, p.birthday
HAVING DATE_PART('year',p.birthday) BETWEEN 1950 AND 1959
ORDER BY p.birthday;
