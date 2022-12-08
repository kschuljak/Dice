DROP TABLE IF EXISTS simple_melee, simple_ranged, martial_melee, martial_ranged, weapon_type, range, property, weapon_property, damage_type, damage_amount, weapon_damage CASCADE;

CREATE TABLE weapon_type
(
    type_id SERIAL NOT NULL PRIMARY KEY,
    type_name VARCHAR(20) NOT NULL
);

CREATE TABLE simple_melee
(
    weapon_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    weapon_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    coin CHAR(2) NOT NULL,
    weight DECIMAL(2,4) NOT NULL
);

CREATE TABLE simple_ranged
(
    weapon_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    weapon_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    coin CHAR(2) NOT NULL,
    weight DECIMAL(2,4) NOT NULL
);

CREATE TABLE martial_melee
(
    weapon_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    weapon_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    coin CHAR(2) NOT NULL,
    weight DECIMAL(2,4) NOT NULL
);

CREATE TABLE martial_ranged
(
    weapon_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    weapon_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    coin CHAR(2) NOT NULL,
    weight DECIMAL(2,4) NOT NULL
);

CREATE TABLE property
(
    property_id SERIAL NOT NULL PRIMARY KEY,
    range_id INT NULL,
    property_name VARCHAR(50) NOT NULL
)

CREATE TABLE range
(
    range_id SERIAL NOT NULL PRIMARY KEY,
    normal_range INT NOT NULL,
    long_range INT NOT NULL
)

CREATE TABLE weapon_property
(
    type_id INT NOT NULL PRIMARY KEY,
    weapon_id INT NOT NULL PRIMARY KEY,
    property_id INT NOT NULL PRIMARY KEY
)

CREATE TABLE damage_amount
(
    amount_id SERIAL NOT NULL PRIMARY KEY,
    number_rolls INT NOT NULL,
    dice_sides INT NOT NULL
)

CREATE TABLE damage_type
(
    damage_id SERIAL NOT NULL PRIMARY KEY,
    damage_name VARCHAR(25) NOT NULL
)

CREATE TABLE weapon_damage
(
    type_id INT NOT NULL PRIMARY KEY,
    weapon_id INT NOT NULL PRIMARY KEY,
    amount_id INT NOT NULL PRIMARY KEY,
    damage_id INT NOT NULL PRIMARY KEY
)

INSERT INTO weapon_type (type_name) VALUES ('Simple Melee');
INSERT INTO weapon_type (type_name) VALUES ('Simple Ranged');
INSERT INTO weapon_type (type_name) VALUES ('Martial Melee');
INSERT INTO weapon_type (type_name) VALUES ('Martial Ranged');

INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Club', 1, 'sp', 2);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Dagger', 2, 'gp', 1);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Greatclub', 2, 'sp', 10);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Handaxe', 5, 'gp', 2);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Javelin', 5, 'sp', 2);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Light Hammer', 2, 'gp', 2);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Mace', 5, 'gp', 4);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Quarterstaff', 2, 'sp', 4);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Sickle', 1, 'gp', 2);
INSERT INTO simple_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Spear', 1, 'gp', 3;

INSERT INTO simple_ranged(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Light Crossbow', 25, 'gp', 5);
INSERT INTO simple_ranged(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Dart', 5, 'cp', 0.25';
INSERT INTO simple_ranged(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Shortbow', 25, 'gp', 2);
INSERT INTO simple_ranged(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Sling', 1, 'sp', 0);

INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Battleaxe', 10, 'gp', 4);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Flail', 10, 'gp', 2);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Glaive', 20, 'gp', 6);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Greataxe', 30, 'gp', 7);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Greatsword', 50, 'gp', 6);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Halberd', 20, 'gp', 6);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Lance', 10, 'gp', 6);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Longsword', 15, 'gp', 3);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Maul', 10, 'gp', 10);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Morningstar', 15, 'gp', 4);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Pike', 5, 'gp', 18);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Rapier', 25, 'gp', 2);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Scimitar', 25, 'gp', 3);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Shortsword', 10, 'gp', 2);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Trident', 5, 'gp', 4);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'War Pick', 5, 'gp', 2);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Warhammer', 15, 'gp', 2);
INSERT INTO martial_melee(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Whip', 2, 'gp', 3);

INSERT INTO martial_ranged(type_id, weapon_name, coin, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Blowgun', 10, 'gp', 1;
INSERT INTO martial_ranged(type_id, weapon_name, coin, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Hand Crossbow', 75, 'gp', 3);
INSERT INTO martial_ranged(type_id, weapon_name, coin, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Heavy Crossbow', 50, 'gp', 18);
INSERT INTO martial_ranged(type_id, weapon_name, coin, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Longbow', 50, 'gp', 2);
INSERT INTO martial_ranged(type_id, weapon_name, coin, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Net', 1, 'gp', 3);

INSERT INTO damage_type(damage_name) VALUES ('bludgeoning');
INSERT INTO damage_type(damage_name) VALUES ('piercing');
INSERT INTO damage_type(damage_name) VALUES ('slashing');

INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (1, 4);
INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (1, 6);
INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (1, 8);
INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (1, 10);
INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (1, 12);
INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (2, 6);

INSERT INTO range(normal_range, long_range) VALUES (5, 15);
INSERT INTO range(normal_range, long_range) VALUES (20, 60);
INSERT INTO range(normal_range, long_range) VALUES (25, 100);
INSERT INTO range(normal_range, long_range) VALUES (30, 120);
INSERT INTO range(normal_range, long_range) VALUES (80, 320);
INSERT INTO range(normal_range, long_range) VALUES (100, 400);
INSERT INTO range(normal_range, long_range) VALUES (150, 600);

INSERT INTO property(property_name) VALUES ('light');
INSERT INTO property(property_name) VALUES ('finesse');
INSERT INTO property(property_name) VALUES ('two-handed');
INSERT INTO property(property_name) VALUES ('versatile (1d8)')
INSERT INTO property(property_name) VALUES ('versatile (1d10)');
INSERT INTO property(property_name) VALUES ('heavy');
INSERT INTO property(property_name) VALUES ('reach');
INSERT INTO property(property_name) VALUES ('finesse');
INSERT INTO property(property_name) VALUES ('loading');
INSERT INTO property(property_name) VALUES ('special');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 5 AND long_range = 15), 'thrown');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 20 AND long_range = 60), 'thrown');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 30 AND long_range = 120), 'thrown');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 25 AND long_range = 100), 'ammunition');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 30 AND long_range = 120), 'ammunition');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 80 AND long_range = 320), 'ammunition');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 100 AND long_range = 400), 'ammunition');
INSERT INTO property(range_id, property_name) VALUES ((SELECT range_id FROM range WHERE normal_range = 150 AND long_range = 600), 'ammunition');


ALTER TABLE simple_melee
ADD CONSTRAINT FK_simple_melee_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE simple_ranged
ADD CONSTRAINT FK_simple_ranged_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE martial_melee
ADD CONSTRAINT FK_martial_melee_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE martial_ranged
ADD CONSTRAINT FK_martial_ranged_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE property
ADD CONSTRAINT FK_property_range
FOREIGN KEY (range_id)
REFERENCES range(range_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_property
FOREIGN KEY (property_id)
REFERENCES property(property_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_simple_melee
FOREIGN KEY (weapon_id)
REFERENCES simple_melee(weapon_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_simple_ranged
FOREIGN KEY (weapon_id)
REFERENCES simple_ranged(weapon_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_martial_melee
FOREIGN KEY (weapon_id)
REFERENCES martial_melee(weapon_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_martial_ranged
FOREIGN KEY (weapon_id)
REFERENCES martial_ranged(weapon_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_damage_amount
FOREIGN KEY (amount_id)
REFERENCES damage_amount(amount_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_damage_type
FOREIGN KEY (damage_id)
REFERENCES damage_type(damage_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_simple_melee
FOREIGN KEY (weapon_id)
REFERENCES simple_melee(weapon_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_simple_ranged
FOREIGN KEY (weapon_id)
REFERENCES simple_ranged(weapon_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_martial_melee
FOREIGN KEY (weapon_id)
REFERENCES martial_melee(weapon_id);

ALTER TABLE weapon_damage
ADD CONSTRAINT FK_weapon_damage_martial_ranged
FOREIGN KEY (weapon_id)
REFERENCES martial_ranged(weapon_id);
