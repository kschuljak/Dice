-- 15. The name and date established of the newest national park.
-- (1 row)

SELECT park_name
	, date_established
FROM park
ORDER BY date_established DESC
LIMIT 1;