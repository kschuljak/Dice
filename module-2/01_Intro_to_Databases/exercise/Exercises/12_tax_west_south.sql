-- 12. The state name, nickname, and sales tax from records in the state table in the "West" and "South" census regions with a sales tax that isn't 0% (26 rows)
SELECT state_name
	, state_nickname
	, sales_tax
FROM state
WHERE sales_tax != 0
	AND census_region IN ('West', 'South');
