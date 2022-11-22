-- 6. The sum of the population of all states in the "South" census region. Name the column 'south_population'.
-- Expected answer is around 125,000,000
-- (1 row)

SELECT SUM(population) AS south_population
FROM state
WHERE census_region = 'South';
