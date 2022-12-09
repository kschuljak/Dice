SELECT *
FROM weapon AS w
JOIN weapon_type AS wt
	ON w.type_id = wt.type_id
JOIN damage_amount AS dm
	ON dm.damage_amount_id = w.damage_amount_id
JOIN damage_type AS dt
	ON dt.damage_type_id = w.damage_type_id
LEFT JOIN weapon_property AS wp
	ON w.weapon_id = wp.weapon_id
LEFT JOIN property AS p
	ON wp.property_id = p.property_id
LEFT JOIN range AS r
	ON p.range_id = r.range_id;