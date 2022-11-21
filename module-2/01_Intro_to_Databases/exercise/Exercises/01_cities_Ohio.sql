-- 1. The name and population of all cities in Ohio (OH) (6 rows)
SELECT city_name
	, population
FROM city
WHERE state_abbreviation = 'OH';

