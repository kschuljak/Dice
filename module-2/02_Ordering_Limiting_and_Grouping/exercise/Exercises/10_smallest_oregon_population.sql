-- 10. The population of the city with the smallest population in Oregon (OR). Name the column 'smallest_oregon_population'.
-- Expected answer is around 100,000
-- (1 row)

SELECT population AS smallest_oregon_population
FROM city
WHERE state_abbreviation = 'OR'
ORDER BY population
LIMIT 1;

