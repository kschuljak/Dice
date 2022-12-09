DROP TABLE IF EXISTS tool, tool_type, water_vehicles, land_vehicles, vehicle_type, gear_type, gear, trade_goods, animals CASCADE;

CREATE TABLE tool_type
(
    type_id SERIAL NOT NULL PRIMARY KEY,
    type_name VARCHAR(10) NOT NULL
);

CREATE TABLE tool
(
    tool_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NULL,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	coin CHAR(2) NOT NULL,
	weight DECIMAL(4,2) NULL
);

CREATE TABLE vehicle_type
(
	type_id SERIAL NOT NULL PRIMARY KEY,
	type_name VARCHAR(50) NOT NULL
);

CREATE TABLE water_vehicles
(
	vehicle_id SERIAL NOT NULL PRIMARY KEY,
	type_id INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	speed DECIMAL(4,2)
);

CREATE TABLE land_vehicles
(
	vehicle_id SERIAL NOT NULL PRIMARY KEY,
	type_id INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	weight INT NOT NULL
);

CREATE TABLE gear_type
(
	type_id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(40) NOT NULL
);

CREATE TABLE gear
(
	gear_id SERIAL NOT NULL PRIMARY KEY,
	type_id INT NULL,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	coin CHAR(2) NOT NULL,
	weight DECIMAL(4,2) NOT NULL
);


CREATE TABLE trade_goods
(
	item_id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	coin CHAR(2) NOT NULL
);

CREATE TABLE animals
(
	animal_id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	speed INT NOT NULL,
	weight_limit INT NOT NULL
);


INSERT INTO tool_type (type_name) VALUES ('artisan');
INSERT INTO tool_type (type_name) VALUES ('gaming');
INSERT INTO tool_type (type_name) VALUES ('musical');


INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'alchemist supplies', 50, 'gp', 8);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'brewer supplies', 20, 'gp', 9);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'calligrapher supplies', 10, 'gp', 5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'carpenter tools', 8, 'gp', 6);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'cartographer tools', 15, 'gp', 6);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'cobbler tools', 5, 'gp', 5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'cook utensils', 1, 'gp', 8);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'glassblower tools', 30, 'gp', 5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'jeweler tools', 25, 'gp', 2);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'leatherworker tools', 5, 'gp', 5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'mason tools', 10, 'gp', 8);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'painter supplies', 10, 'gp', 5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'potter tools', 10, 'gp', 3);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'smith tools', 20, 'gp', 8);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'tinker tools', 50, 'gp', 10);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'weaver tools', 1, 'gp', 5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'artisan'), 'woodcarver tools', 1, 'gp', 5);

INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'gaming'), 'dice set', 1, 'sp', 0);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'gaming'), 'dragonchess set', 1, 'gp', 0.5);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'gaming'), 'playing card set', 5, 'sp', 0);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'gaming'), 'three-dragon ante set', 1, 'gp', 0);

INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'bagpipes', 30, 'gp', 6);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'drum', 6, 'gp', 3);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'dulcimer', 25, 'gp', 10);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'flute', 2, 'gp', 1);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'lute', 35, 'gp', 2);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'lyre', 30, 'gp', 2);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'horn', 3, 'gp', 2);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'pan flute', 12, 'gp', 2);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'shawm', 2, 'gp', 1);
INSERT INTO tool (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM tool_type WHERE type_name = 'musical'), 'viol', 30, 'gp', 1);

INSERT INTO tool (name, cost, coin, weight) VALUES ('disguise kit', 25, 'gp', 3);
INSERT INTO tool (name, cost, coin, weight) VALUES ('forgery kit', 15, 'gp', 5);
INSERT INTO tool (name, cost, coin, weight) VALUES ('herbalism kit', 5, 'gp', 3);
INSERT INTO tool (name, cost, coin, weight) VALUES ('navigator tools', 25, 'gp', 2);
INSERT INTO tool (name, cost, coin, weight) VALUES ('poisoner kit', 50, 'gp', 2);
INSERT INTO tool (name, cost, coin, weight) VALUES ('thieves kit', 25, 'gp', 1);


INSERT INTO vehicle_type (type_name) VALUES ('land');
INSERT INTO vehicle_type (type_name) VALUES ('water');


INSERT INTO water_vehicles (type_id, name, cost, speed) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'water'), 'galley', 30000, 4);
INSERT INTO water_vehicles (type_id, name, cost, speed) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'water'), 'keelboat', 3000, 1);
INSERT INTO water_vehicles (type_id, name, cost, speed) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'water'), 'longship', 10000, 3);
INSERT INTO water_vehicles (type_id, name, cost, speed) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'water'), 'rowboat', 50, 1.5);
INSERT INTO water_vehicles (type_id, name, cost, speed) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'water'), 'sailing ship', 10000, 2);
INSERT INTO water_vehicles (type_id, name, cost, speed) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'water'), 'warship', 25000, 2.5);


INSERT INTO land_vehicles (type_id, name, cost, weight) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'land'), 'carriage', 100, 600);
INSERT INTO land_vehicles (type_id, name, cost, weight) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'land'), 'cart', 15, 200);
INSERT INTO land_vehicles (type_id, name, cost, weight) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'land'), 'chariot', 250, 100);
INSERT INTO land_vehicles (type_id, name, cost, weight) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'land'), 'sled', 20, 300);
INSERT INTO land_vehicles (type_id, name, cost, weight) VALUES ((SELECT type_id FROM vehicle_type WHERE type_name = 'land'), 'wagon', 35, 400);


INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('camel', 50, 50, 480);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('donkey', 8, 40, 420);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('mule', 8, 40, 420);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('elephant', 200, 40, 1320);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('draft horse', 50, 40, 540);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('riding horse', 75, 60, 480);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('mastiff', 25, 40, 195);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('pony', 30, 40, 225);
INSERT INTO animals (name, cost, speed, weight_limit) VALUES ('warhorse', 400, 60, 540);


INSERT INTO trade_goods (name, cost, coin) VALUES ('wheat', 1, 'cp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('flour', 2, 'cp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('chicken', 2, 'cp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('salt', 5, 'cp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('iron', 1, 'sp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('canvas', 1, 'sp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('copper', 5, 'sp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('cotton cloth', 5, 'sp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('ginger', 1, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('goat', 1, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('cinnamon', 2, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('pepper', 2, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('sheep', 2, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('cloves', 3, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('pig', 3, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('silver', 5, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('linen', 5, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('silk', 10, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('cow', 10, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('saffron', 15, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('ox', 15, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('gold', 50, 'gp');
INSERT INTO trade_goods (name, cost, coin) VALUES ('platinum', 500, 'gp');


INSERT INTO gear_type (name) VALUES ('ammunition');
INSERT INTO gear_type (name) VALUES ('arcane focus');
INSERT INTO gear_type (name) VALUES ('druidic focus');
INSERT INTO gear_type (name) VALUES ('holy symbol');
INSERT INTO gear_type (name) VALUES ('vial');
INSERT INTO gear_type (name) VALUES ('flask');
INSERT INTO gear_type (name) VALUES ('1 ounce bottle');
INSERT INTO gear_type (name) VALUES ('bag of 20');
INSERT INTO gear_type (name) VALUES ('bag of 1000');
INSERT INTO gear_type (name) VALUES ('one sheet');
INSERT INTO gear_type (name) VALUES ('one piece');
INSERT INTO gear_type (name) VALUES ('10 feet');
INSERT INTO gear_type (name) VALUES ('50 feet');


INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'ammunition'), 'arrows - 20', 1, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'ammunition'), 'blowgun needles - 50', 1, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'ammunition'), 'crossbow bolts - 20', 1, 'gp', 1.5);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'ammunition'), 'sling bullets - 20', 4, 'cp', 1.5);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'arcane focus'), 'crystal', 10, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'arcane focus'), 'orb', 20, 'gp', 3);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'arcane focus'), 'rod', 10, 'gp', 2);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'arcane focus'), 'staff', 5, 'gp', 4);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'arcane focus'), 'wand', 10, 'gp', 1);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'druidic focus'), 'sprig of mistletoe', 1, 'gp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'druidic focus'), 'totem', 1, 'gp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'druidic focus'), 'wooden staff', 5, 'gp', 4);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'druidic focus'), 'yew wand', 10, 'gp', 1);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'holy symbol'), 'amulet', 5, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'holy symbol'), 'emblem', 5, 'gp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'holy symbol'), 'reliquary', 5, 'gp', 2);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'vial'), 'acid', 25, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'vial'), 'antitoxin', 50, 'gp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'vial'), 'perfume', 5, 'gp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'vial'), 'basic poison', 100, 'gp', 0);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'flask'), 'alchemist fire', 50, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'flask'), 'holy water', 25, 'gp', 1);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'flask'), 'oil', 1, 'sp', 1);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = '1 ounce bottle'), 'ink', 10, 'gp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'bag of 20'), 'caltrops', 1, 'gp', 2);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'bag of 1000'), 'ball bearings', 1, 'gp', 2);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'one sheet'), 'paper', 2, 'sp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'one sheet'), 'parchment', 1, 'sp', 0);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = 'one piece'), 'chalk', 1, 'cp', 0);

INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = '10 feet'), 'chain', 5, 'gp', 10);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = '10 feet'), 'ladder', 1, 'sp', 25);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = '10 feet'), 'pole', 5, 'cp', 7);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = '50 feet'), 'hempen rope', 1, 'gp', 10);
INSERT INTO gear (type_id, name, cost, coin, weight) VALUES ((SELECT type_id FROM gear_type WHERE name = '50 feet'), 'silk rope', 10, 'gp', 5);

INSERT INTO gear (name, cost, coin, weight) VALUES ('abacus', 2, 'gp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('backpack', 2, 'gp', 5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('barrel', 2, 'gp', 70);
INSERT INTO gear (name, cost, coin, weight) VALUES ('basket', 4, 'sp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('bedroll', 1, 'gp', 7);
INSERT INTO gear (name, cost, coin, weight) VALUES ('bell', 1, 'gp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('blanket', 5, 'sp', 3);
INSERT INTO gear (name, cost, coin, weight) VALUES ('block and tackle', 1, 'gp', 5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('book', 25, 'gp', 5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('glass bottle', 2, 'gp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('bucket', 5, 'cp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('candle', 1, 'cp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('crossbow bolt case', 1, 'gp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('map or scroll case', 1, 'gp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('chest', 5, 'gp', 25);
INSERT INTO gear (name, cost, coin, weight) VALUES ('climbing kit', 25, 'gp', 12);
INSERT INTO gear (name, cost, coin, weight) VALUES ('common clothes', 5, 'sp', 3);
INSERT INTO gear (name, cost, coin, weight) VALUES ('costume clothes', 5, 'gp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('fine clothes', 15, 'gp', 6);
INSERT INTO gear (name, cost, coin, weight) VALUES ('traveling clothes', 2, 'gp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('component pouch', 25, 'gp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('crowbar', 2, 'gp', 5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('fishing tackle', 1, 'gp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('flask', 2, 'cp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('tankard', 2, 'cp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('grappling hook', 2, 'gp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('hammer', 1, 'gp', 3);
INSERT INTO gear (name, cost, coin, weight) VALUES ('sledge hammer', 2, 'gp', 10);
INSERT INTO gear (name, cost, coin, weight) VALUES ('healer kit', 5, 'gp', 3);
INSERT INTO gear (name, cost, coin, weight) VALUES ('hourglass', 25, 'gp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('hunting trap', 5, 'gp', 25);
INSERT INTO gear (name, cost, coin, weight) VALUES ('ink pen', 2, 'cp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('jug', 2, 'cp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('pitcher', 2, 'cp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('lamp', 5, 'sp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('bullseye lantern', 10, 'gp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('hooded lantern', 5, 'gp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('lock', 10, 'gp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('magnifying glass', 100, 'gp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('manacles', 2, 'gp', 6);
INSERT INTO gear (name, cost, coin, weight) VALUES ('mess kit', 2, 'sp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('steel mirror', 5, 'gp', 0.5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('mining pick', 2, 'gp', 10);
INSERT INTO gear (name, cost, coin, weight) VALUES ('piton', 5, 'cp', 0.25);
INSERT INTO gear (name, cost, coin, weight) VALUES ('iron pot', 2, 'gp', 10);
INSERT INTO gear (name, cost, coin, weight) VALUES ('potion of healing', 50, 'gp', 0.5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('pouch', 5, 'cp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('quiver', 1, 'gp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('portable ram', 4, 'gp', 35);
INSERT INTO gear (name, cost, coin, weight) VALUES ('days rations', 5, 'sp', 2);
INSERT INTO gear (name, cost, coin, weight) VALUES ('robes', 1, 'gp', 4);
INSERT INTO gear (name, cost, coin, weight) VALUES ('sack', 1, 'cp', 0.5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('merchant scale', 5, 'gp', 3);
INSERT INTO gear (name, cost, coin, weight) VALUES ('sealing wax', 5, 'sp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('shovel', 2, 'gp', 5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('signal whistle', 5, 'cp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('signet ring', 5, 'gp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('soap', 2, 'cp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('spellbook', 50, 'gp', 3);
INSERT INTO gear (name, cost, coin, weight) VALUES ('spyglass', 1000, 'gp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('two-person tent', 2, 'gp', 20);
INSERT INTO gear (name, cost, coin, weight) VALUES ('tinderbox', 5, 'sp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('torch', 1, 'cp', 1);
INSERT INTO gear (name, cost, coin, weight) VALUES ('vial', 1, 'gp', 0);
INSERT INTO gear (name, cost, coin, weight) VALUES ('waterskin', 2, 'sp', 5);
INSERT INTO gear (name, cost, coin, weight) VALUES ('whetstone', 1, 'cp', 1);


ALTER TABLE gear
ADD CONSTRAINT FK_gear_gear_type
FOREIGN KEY (gear_id)
REFERENCES gear(gear_id);

ALTER TABLE tool
ADD CONSTRAINT FK_tool_tool_type
FOREIGN KEY (type_id)
REFERENCES tool_type(type_id);

ALTER TABLE water_vehicles
ADD CONSTRAINT FK_water_vehicles_vehicle_type
FOREIGN KEY (type_id)
REFERENCES vehicle_type(type_id);

ALTER TABLE land_vehicles
ADD CONSTRAINT FK_land_vehicles_vehicle_type
FOREIGN KEY (type_id)
REFERENCES vehicle_type(type_id);
