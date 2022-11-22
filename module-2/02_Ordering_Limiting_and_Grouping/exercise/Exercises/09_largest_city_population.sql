-- 9. The population of the city with the highest population. Name the column 'largest_city_population'.
-- Expected answer is around 8,300,000
-- (1 row)

SELECT population AS largest_city_population
FROM city
ORDER BY population DESC
limit 1;