
DROP TABLE IF EXISTS shield, light_armor, medium_armor, heavy_armor, armor_type CASCADE;

CREATE TABLE armor_type 
(
    type_id SERIAL NOT NULL PRIMARY KEY,
    type_name VARCHAR(20) NOT NULL,
    ac_modifier VARCHAR(20) NOT NULL
);

CREATE TABLE light_armor 
(
    armor_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    armor_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    armor_class INT NOT NULL,
    stealth_disadvantage BOOLEAN NOT NULL,
    weight INT NOT NULL
);

CREATE TABLE medium_armor 
(
    armor_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    armor_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    armor_class INT NOT NULL,
    stealth_disadvantage BOOLEAN NOT NULL,
    weight INT NOT NULL
);

CREATE TABLE heavy_armor 
(
    armor_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    armor_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    armor_class INT NOT NULL,
    strength_min INT NULL,
    stealth_disadvantage BOOLEAN NOT NULL,
    weight INT NOT NULL
);

CREATE TABLE shield 
(
    shield_id SERIAL NOT NULL PRIMARY KEY,
    type_id INT NOT NULL,
    shield_name VARCHAR(30) NOT NULL,
    cost INT NOT NULL,
    weight INT NOT NULL
);

INSERT INTO armor_type (type_name, ac_modifier) VALUES ('Light Armor', '+ dex mod');
INSERT INTO armor_type (type_name, ac_modifier) VALUES ('Medium Armor', '+ dex mod (max 2)');
INSERT INTO armor_type (type_name, ac_modifier) VALUES ('Heavy Armor', '+0');
INSERT INTO armor_type (type_name, ac_modifier) VALUES ('Shield', '+2');

INSERT INTO light_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Light Armor'), 'Padded Armor', 5, 11, true, 8);
INSERT INTO light_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Light Armor'), 'Leather Armor', 10, 11, false, 10);
INSERT INTO light_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Light Armor'), 'Studded Leather Armor', 45, 12, false, 13);

INSERT INTO medium_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Medium Armor'), 'Hide Armor', 10, 12, false, 12);
INSERT INTO medium_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Medium Armor'), 'Chain Shirt', 50, 13, false, 20);
INSERT INTO medium_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Medium Armor'), 'Scale Mail', 50, 14, true, 45);
INSERT INTO medium_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Medium Armor'), 'Breastplate', 400, 14, false, 20);
INSERT INTO medium_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Medium Armor'), 'Half Plate Armor', 750, 15, true, 40);


INSERT INTO heavy_armor(type_id, armor_name, cost, armor_class, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Heavy Armor'), 'Ring Mail Armor', 30, 14, true, 40);
INSERT INTO heavy_armor(type_id, armor_name, cost, armor_class, strength_min, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Heavy Armor'), 'Chain Mail Armor', 75, 16, 13, true, 55);
INSERT INTO heavy_armor(type_id, armor_name, cost, armor_class, strength_min, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Heavy Armor'), 'Splint Armor', 200, 17, 15, true, 60);
INSERT INTO heavy_armor(type_id, armor_name, cost, armor_class, strength_min, stealth_disadvantage, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Heavy Armor'), 'Plate Armor', 1500, 18, 15, true, 65);

INSERT INTO shield(type_id, shield_name, cost, weight) VALUES ((SELECT type_id FROM armor_type WHERE type_name = 'Shield'), 'Shield', 10, 6);

ALTER TABLE light_armor
ADD CONSTRAINT FK_light_armor_armor_type 
FOREIGN KEY (type_id) 
REFERENCES armor_type(type_id);

ALTER TABLE medium_armor 
ADD CONSTRAINT FK_medium_armor_armor_type 
FOREIGN KEY (type_id) 
REFERENCES armor_type(type_id);

ALTER TABLE heavy_armor 
ADD CONSTRAINT FK_heavy_armor_armor_type 
FOREIGN KEY (type_id) 
REFERENCES armor_type(type_id);

ALTER TABLE shield 
ADD CONSTRAINT FK_shield_armor_type 
FOREIGN KEY (type_id) 
REFERENCES armor_type(type_id);

