
SELECT avg(population)
FROM city;

-- give me all cities that are
-- bigger (have a great population)
-- than the average population of all cities

SELECT *
FROM city 
WHERE population <= (
    SELECT avg(population)
    FROM city
);