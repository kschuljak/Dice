-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_abbreviation
	, population
FROM state
ORDER BY population DESC;

SELECT state_abbreviation
	, population
FROM state
ORDER BY 2 DESC;
-- order by 2nd row descending, NOT 0-based

SELECT state_abbreviation AS "state"
	, population AS pop
FROM state
ORDER BY pop DESC;

-- ORDER OF OPERATIONS:
-- SELECT   - 5th
-- FROM     - 1st
-- WHERE    - 2nd
-- GROUP BY - 3rd
-- HAVING   - 4th
-- ORDER BY - 6th
-- LIMIT    - 7th


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name
	, census_region
FROM state
ORDER BY census_region DESC, state_name;


-- The biggest park by area
SELECT park_name
	, area
FROM park
ORDER BY area DESC
LIMIT 1;



-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name
	, population
FROM city
ORDER BY population DESC
LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name
	, DATE_PART('year', CURRENT_DATE) - DATE_PART('year',date_established) AS years_old
FROM park
ORDER BY years_old DESC, park_name
LIMIT 20;
-- LIMIT, DATE_PART is postgreSQL = not standard

-- SUBQUERY - use a sub-query as a data source
-- 20 oldest parks
-- sorted fully alphabetically
SELECT *
FROM
(
	SELECT park_name AS "name"
		, DATE_PART('year', CURRENT_DATE) - DATE_PART('year',date_established) AS age
	FROM park
	ORDER BY age DESC
	LIMIT 20
) AS temp_parks
ORDER BY name;


SELECT "name"
	, age
	, days_old * 365
FROM
(
	SELECT park_name AS "name"
		, DATE_PART('year', CURRENT_DATE) - DATE_PART('year',date_established) AS age
		, CURRENT_DATE - date_established AS days_old
	FROM park
	ORDER BY age DESC
	LIMIT 20
) AS temp_parks
ORDER BY name;


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name ||', '|| state_abbreviation AS city_state
from city;

-- available in all modern RDBMS's
SELECT CONCAT(city_name, ', ', state_abbreviation) AS city_state
from city;


-- The all parks by name and date established.
SELECT park_name || '  (est. ' || DATE_PART('year',date_established) || ')' AS park_year_established
from park;

SELECT park_name || '  (est. ' || DATE_PART('year',date_established) || ')' AS park_year_established
from park
ORDER BY date_established;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT state_name || '  -  ' || census_region || '  (pop. ' || population || ')' AS state_region
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY census_region, state_name;



-- AGGREGATE FUNCTIONS
-- count gives you the number of rows meeting requirements
SELECT COUNT(*)
FROM state
WHERE population < 1000000;

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) as avg_population
FROM state;


-- Total population in the West and South census regions
SELECT COUNT(*) AS all_territory_count
	, COUNT(census_region) AS state_count
	, COUNT(DISTINCT census_region) as census_region_count
FROM state;


SELECT SUM(population) as summed_population
FROM state
WHERE census_region IN ('West', 'South');


-- The number of cities with populations greater than 1 million
SELECT COUNT(*) AS num_of_cities
FROM city
WHERE population > 1000000;


-- The number of state nicknames.
SELECT COUNT(*) AS has_nickname
FROM state
WHERE state_nickname IS NOT NULL;

SELECT COUNT(state_nickname)
FROM state;



-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest
	, MAX(area) AS largest
FROM park;

SELECT *
FROM park
WHERE area = (	
			SELECT MIN(area) as smallest_park
			FROM park
			);



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation
	, COUNT(*) AS city_count 
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping
	, AVG(area) AS avg_area
FROM park
GROUP BY has_camping;

-- use WHERE to filter the RAW data

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation
	, SUM(population) AS state_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;


-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation
	, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city;



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

