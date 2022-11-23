-- INNER JOIN

-- give all cities bigger than the average population of all cities

SELECT AVG(population)
FROM city;

SELECT *
FROM city
WHERE population >= (
	SELECT avg(population)
	FROM city
);


-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database



-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).


-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)


-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.




-- Modify the previous query to include the name of the state's capital city.

SELECT p.park_name
	, s.state_name
	, s.capital
	, c.city_id
	, c.city_name
FROM park as p
INNER JOIN park_state AS ps
	ON p.park_id = ps.park_id
INNER JOIN state AS s
	ON ps.state_abbreviation = s.state_abbreviation
INNER JOIN city AS c
-- join state's capital to city's city id
	ON s.capital = c.city_id;


-- Modify the previous query to include the area of each park.
SELECT p.park_name
	, p.area AS park_area 
	, s.state_name
	, c.city_name AS state_capital
FROM park as p
INNER JOIN park_state AS ps
	ON p.park_id = ps.park_id
INNER JOIN state AS s
	ON ps.state_abbreviation = s.state_abbreviation
INNER JOIN city AS c
	ON s.capital = c.city_id;


-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT c.city_name
	, c.population
FROM city AS c
INNER JOIN state AS s
	ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest';

SELECT c.city_name || ', ' || c.state_abbreviation AS city_state
	, c.population
FROM city AS c
INNER JOIN state AS s
	ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest';


-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT COUNT(c.city_name) AS cities_in_midwest
FROM city AS c
INNER JOIN state AS s
	ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest';


-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT COUNT(c.city_name) AS cities_per_state
	, s.state_name
FROM city AS c
INNER JOIN state AS s
	ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_name
ORDER BY cities_per_state DESC, state_name;


-- LEFT JOIN

-- Write a query to retrieve the state name 
-- and the earliest date a park was established in that state (or territory) 
-- for every record in the state table that has park records associated with it.

SELECT s.state_name
	, p.park_name
	, p.date_established
FROM state AS s
INNER JOIN park_state AS ps
	ON s.state_abbreviation = ps.state_abbreviation
INNER JOIN park AS p
	ON ps.park_id = p.park_id
ORDER BY s.state_name
	, p.park_name;
	
SELECT s.state_name
	, MIN(p.date_established) AS first_park_established_in
FROM state AS s
INNER JOIN park_state AS ps
	ON s.state_abbreviation = ps.state_abbreviation
INNER JOIN park AS p
	ON ps.park_id = p.park_id
GROUP BY s.state_name
ORDER BY s.state_name;


-- Modify the previous query so the results include entries for all the records in the state table, 
-- even if they have no park records associated with them.

-- once you do a left join, everything following should be a left join - 'turtles all the way down'
SELECT s.state_name
	, MIN(p.date_established) AS first_park_established_in
FROM state AS s
LEFT JOIN park_state AS ps
	ON s.state_abbreviation = ps.state_abbreviation
LEFT JOIN park AS p
	ON ps.park_id = p.park_id
GROUP BY s.state_name
ORDER BY s.state_name;



-- UNION
-- joining tables means we add all columns from both tables
-- union means we want to add ROWS from both tables - add rows


-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. 
-- (Washington is the name of a city and a state--how many times does it appear in the results?)

SELECT city_name
FROM city
WHERE city_name ILIKE 'w%'

UNION -- merge results

SELECT state_name
FROM state
WHERE state_name ILIKE 'w%';
-- only one 'Washington' b/c UNION will merge common rows


SELECT city_name
FROM city
WHERE city_name ILIKE 'w%'

UNION ALL -- append second result to first

SELECT state_name
FROM state
WHERE state_name ILIKE 'w%';
-- UNION ALL combines all, sorts first set then appends second set


-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place
	, 'city' AS type
FROM city
WHERE city_name ILIKE 'w%'

UNION ALL -- append second result to first

SELECT state_name
	, 'state' -- column name 'type' defined in first query
FROM state
WHERE state_name ILIKE 'w%';


SELECT city_name AS place
	, 'city' AS type
FROM city
WHERE city_name ILIKE 'w%'

UNION -- merge, but now washington type city != washing type state

SELECT state_name
	, 'state'
FROM state
WHERE state_name ILIKE 'w%';


-- MovieDB
-- After creating the MovieDB database and running the setup script, 
-- make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

