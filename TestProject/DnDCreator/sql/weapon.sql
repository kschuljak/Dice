DROP TABLE IF EXISTS weapon, weapon_type, range, property, weapon_property, damage_type, damage_amount CASCADE;

CREATE TABLE weapon_type
(
    type_id SERIAL NOT NULL PRIMARY KEY,
    type_name VARCHAR(20) NOT NULL
);

CREATE TABLE weapon
(
    weapon_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    weapon_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    coin CHAR(2) NOT NULL,
    weight DECIMAL(2,4) NOT NULL,
    damage_amount_id INT NOT NULL,
    damage_type_id INT NOT NULL
);

CREATE TABLE property
(
    property_id SERIAL NOT NULL PRIMARY KEY,
    range_id INT NULL,
    property_name VARCHAR(50) NOT NULL
);

CREATE TABLE range
(
    range_id SERIAL NOT NULL PRIMARY KEY,
    normal_range INT NOT NULL,
    long_range INT NOT NULL
);

CREATE TABLE weapon_property
(
    weapon_id INT NOT NULL PRIMARY KEY,
    property_id INT NOT NULL PRIMARY KEY
);

CREATE TABLE damage_amount
(
    amount_id SERIAL NOT NULL PRIMARY KEY,
    number_rolls INT NOT NULL,
    dice_sides INT NOT NULL
);

CREATE TABLE damage_type
(
    damage_id SERIAL NOT NULL PRIMARY KEY,
    damage_name VARCHAR(25) NOT NULL
);


INSERT INTO weapon_type (type_name) VALUES ('Simple Melee');
INSERT INTO weapon_type (type_name) VALUES ('Simple Ranged');
INSERT INTO weapon_type (type_name) VALUES ('Martial Melee');
INSERT INTO weapon_type (type_name) VALUES ('Martial Ranged');

INSERT INTO damage_type(damage_name) VALUES ('bludgeoning');
INSERT INTO damage_type(damage_name) VALUES ('piercing');
INSERT INTO damage_type(damage_name) VALUES ('slashing');

INSERT INTO damage_amount(number_rolls, dice_sides) VALUES (1, 1);
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
INSERT INTO property(property_name) VALUES ('versatile - 1d8');
INSERT INTO property(property_name) VALUES ('versatile - 1d10');
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

INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Club', 1, 'sp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Dagger', 2, 'gp', 1,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Greatclub', 2, 'sp', 10,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Handaxe', 5, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Javelin', 5, 'sp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Light Hammer', 2, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Mace', 5, 'gp', 4,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Quarterstaff', 2, 'sp', 4,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Sickle', 1, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Melee'), 'Spear', 1, 'gp', 3,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));

INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Light Crossbow', 25, 'gp', 5,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Dart', 5, 'cp', 0.25,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Shortbow', 25, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Simple Ranged'), 'Sling', 1, 'sp', 0,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));

INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Battleaxe', 10, 'gp', 4,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Flail', 10, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Glaive', 20, 'gp', 6,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 10),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Greataxe', 30, 'gp', 7,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 12),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Greatsword', 50, 'gp', 6,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 2 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Halberd', 20, 'gp', 6,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 10),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Lance', 10, 'gp', 6,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 12),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Longsword', 15, 'gp', 3,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Maul', 10, 'gp', 10,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 2 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Morningstar', 15, 'gp', 4,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Pike', 5, 'gp', 18,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 10),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Rapier', 25, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Scimitar', 25, 'gp', 3,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Shortsword', 10, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Trident', 5, 'gp', 4,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'War Pick', 5, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Warhammer', 15, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'bludgeoning'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Melee'), 'Whip', 2, 'gp', 3,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 4),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'slashing'));

INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Blowgun', 10, 'gp', 1,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 1),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Hand Crossbow', 75, 'gp', 3,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 6),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Heavy Crossbow', 50, 'gp', 18,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 10),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight, damage_amount_id, damage_type_id) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Longbow', 50, 'gp', 2,
                                                                                                       (SELECT damage_amount_id FROM damage_amount WHERE number_rolls = 1 AND dice_sides = 8),
                                                                                                       (SELECT damage_type_id FROM damage_type WHERE damage_name = 'piercing'));
INSERT INTO weapon(type_id, weapon_name, cost, coin, weight) VALUES ((SELECT type_id FROM weapon_type WHERE type_name = 'Martial Ranged'), 'Net', 1, 'gp', 3);


INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Club'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Dagger'), (SELECT property_id FROM property WHERE property_name = 'finesse'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Dagger'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Greatclub'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Handaxe'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Light Hammer'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Quarterstaff'), (SELECT property_id FROM property WHERE property_name = 'versatile - 1d8'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Sickle'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Spear'), (SELECT property_id FROM property WHERE property_name = 'versatile - 1d8'));

INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Light Crossbow'), (SELECT property_id FROM property WHERE property_name = 'loading'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Light Crossbow'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Dart'), (SELECT property_id FROM property WHERE property_name = 'finesse'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Shortbow'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));

INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Battleaxe'), (SELECT property_id FROM property WHERE property_name = 'versatile - 1d10'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Glaive'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Glaive'), (SELECT property_id FROM property WHERE property_name = 'reach'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Glaive'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Greataxe'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Greataxe'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Greatsword'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Greatsword'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Halberd'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Halberd'), (SELECT property_id FROM property WHERE property_name = 'reach'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Halberd'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Lance'), (SELECT property_id FROM property WHERE property_name = 'reach'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Lance'), (SELECT property_id FROM property WHERE property_name = 'special'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Longsword'), (SELECT property_id FROM property WHERE property_name = 'versatile - 1d10'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Maul'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Maul'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Pike'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Pike'), (SELECT property_id FROM property WHERE property_name = 'reach'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Pike'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Rapier'), (SELECT property_id FROM property WHERE property_name = 'finesse'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Scimitar'), (SELECT property_id FROM property WHERE property_name = 'finesse'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Scimitar'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Shortsword'), (SELECT property_id FROM property WHERE property_name = 'finesse'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Shortsword'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Warhammer'), (SELECT property_id FROM property WHERE property_name = 'versatile - 1d10'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Whip'), (SELECT property_id FROM property WHERE property_name = 'finesse'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Whip'), (SELECT property_id FROM property WHERE property_name = 'reach'));

INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Blowgun'), (SELECT property_id FROM property WHERE property_name = 'loading'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Hand Crossbow'), (SELECT property_id FROM property WHERE property_name = 'light'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Hand Crossbow'), (SELECT property_id FROM property WHERE property_name = 'loading'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Heavy Crossbow'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Heavy Crossbow'), (SELECT property_id FROM property WHERE property_name = 'loading'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Heavy Crossbow'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Longbow'), (SELECT property_id FROM property WHERE property_name = 'heavy'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Longbow'), (SELECT property_id FROM property WHERE property_name = 'two-handed'));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Net'), (SELECT property_id FROM property WHERE property_name = 'special'));


INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Dagger'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 20));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Handaxe'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 20));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Javelin'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 30));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Light Hammer'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 20));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Spear'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 20));

INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Light Crossbow'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 80));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Dart'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 20));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Shortbow'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 80));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Sling'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 30));

INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Trident'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 20));

INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Blowgun'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 25));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Hand Crossbow'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 30));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Heavy Crossbow'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 100));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Longbow'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'ammunition' AND r.normal_range = 150));
INSERT INTO weapon_property(weapon_id, property_id) VALUES ((SELECT weapon_id FROM weapon WHERE weapon_name = 'Net'),
                                                            (SELECT property_id FROM property AS p JOIN range AS r ON p.range_id = r.range_id WHERE p.property_name = 'thrown' AND r.normal_range = 5));



ALTER TABLE weapon
ADD CONSTRAINT FK_weapon_weapon_type
FOREIGN KEY (type_id)
REFERENCES weapon_type(type_id);

ALTER TABLE weapon
ADD CONSTRAINT FK_weapon_damage_amount
FOREIGN KEY (damage_amount_id)
REFERENCES damage_amount(damage_amount_id);

ALTER TABLE weapon
ADD CONSTRAINT FK_weapon_damage_type
FOREIGN KEY (damage_type_id)
REFERENCES damage_type(damage_type_id);

ALTER TABLE property
ADD CONSTRAINT FK_property_range
FOREIGN KEY (range_id)
REFERENCES range(range_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_weapon
FOREIGN KEY (weapon_id)
REFERENCES weapon(weapon_id);

ALTER TABLE weapon_property
ADD CONSTRAINT FK_weapon_property_property
FOREIGN KEY (property_id)
REFERENCES property(property_id);



