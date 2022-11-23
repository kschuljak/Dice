-- INNER JOIN

-- Write a query to retrieve the name and 
-- state abbreviation for the 2 cities named 
-- "Columbus" in the database
SELECT city_name
    , state_abbreviation
FROM city
WHERE city_name = 'Columbus';


-- Modify the previous query to retrieve the 
-- names of the states (rather than their abbreviations).
SELECT c.city_name
    , s.state_name
FROM city as c
INNER JOIN state as s
    on c.state_abbreviation = s.state_abbreviation
WHERE c.city_name = 'Columbus';


-- Write a query to retrieve the names of all the 
-- national parks with their state abbreviations.
-- (Some parks will appear more than once in the 
-- results, because they cross state boundaries.)

SELECT p.park_name
    , ps.state_abbreviation
FROM park as p
INNER JOIN park_state as ps
    ON p.park_id = ps.park_id;



-- The park_state table is an associative table 
-- that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names 
-- of the states rather than their abbreviations.

SELECT p.park_name
    --, ps.state_abbreviation
    , s.state_name
FROM park as p
INNER JOIN park_state as ps
    ON p.park_id = ps.park_id
INNER JOIN state as s
    ON ps.state_abbreviation = s.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.

SELECT p.park_name
    --, ps.state_abbreviation
    , s.state_name
    , s.capital
    , c.city_id
    , c.city_name
FROM park as p
INNER JOIN park_state as ps
    ON p.park_id = ps.park_id
INNER JOIN state as s
    ON ps.state_abbreviation = s.state_abbreviation
INNER JOIN city as c
    ON s.capital = c.city_id;


-- Modify the previous query to include the area of each park.

SELECT p.park_name
    , p.area as park_area
    , s.state_name
    , c.city_name as state_capital
FROM park as p
INNER JOIN park_state as ps
    ON p.park_id = ps.park_id
INNER JOIN state as s
    ON ps.state_abbreviation = s.state_abbreviation
INNER JOIN city as c
    ON s.capital = c.city_id;

-- Write a query to retrieve the names and populations 
-- of all the cities in the Midwest census region.
SELECT c.city_name
    , c.population
FROM city as c
INNER JOIN state as s
    on c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest';


-- Write a query to retrieve the number of 
-- cities in the city table for each state in the Midwest census region.
SELECT count(*) as cities_in_midwest
FROM city as c
INNER JOIN state as s
    on c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest';

-- Modify the previous query to sort the results 
-- by the number of cities in descending order.



-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.



-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)


-- Modify the previous query to include a column that indicates whether the place is a city or state.



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

