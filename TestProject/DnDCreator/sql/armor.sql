BEGIN TRANSACTION;

DROP TABLE IF EXISTS shield
DROP TABLE IF EXISTS light_armor
DROP TABLE IF EXISTS medium_armor
DROP TABLE IF EXISTS heavy_armor
DROP TABLE IF EXISTS armor

CREATE TABLE armor (
    armor_id serial,
    name varchar(15) NOT NULL,
    ac_mod varchar(10) NOT NULL,
    CONSTRAINT PK_armor_armor_id PRIMARY KEY (armor_id)
)

CREATE TABLE light_armor (
    id serial,
    armor_id integer NOT NULL,
    name varchar(20) NOT NULL,
    cost integer NOT NULL,
    ac integer NOT NULL,
    stealth_disadvantage boolean NOT NULL,
    weight integer NOT NULL
    CONSTRAINT PK_light_armor_id PRIMARY KEY (id)
)

CREATE TABLE medium_armor (
    id serial,
    armor_id integer NOT NULL,
    name varchar(20) NOT NULL,
    cost integer NOT NULL,
    ac integer NOT NULL,
    stealth_disadvantage boolean NOT NULL,
    weight integer NOT NULL
    CONSTRAINT PK_medium_armor_id PRIMARY KEY (id)
)

CREATE TABLE heavy_armor (
    id serial,
    armor_id integer NOT NULL,
    name varchar(20) NOT NULL,
    cost integer NOT NULL,
    ac integer NOT NULL,
    strength_required integer NULL,
    stealth_disadvantage boolean NOT NULL,
    weight integer NOT NULL
    CONSTRAINT PK_heavy_armor_id PRIMARY KEY (id)
)

CREATE TABLE shield (
    id serial,
    armor_id integer NOT NULL,
    name varchar(20) NOT NULL,
    cost integer NOT NULL,
    weight integer NOT NULL,
    CONSTRAINT PK_shield_id PRIMARY KEY (id)
)

INSERT INTO armor (name, ac_mod) VALUES ('Light Armor', '+ dex mod');
INSERT INTO armor (name, ac_mod) VALUES ('Medium Armor', '+ dex mod (max 2)');
INSERT INTO armor (name, ac_mod) VALUES ('Heavy Armor', '+0');
INSERT INTO armor (name, ac_mod) VALUES ('Shield', '+2');

INSERT INTO light_armor(armor_id, name, cost, ac, stealth_disadvantage, weight)
VALUES ((SELECT armor_id FROM armor WHERE name = 'Light Armor'), 'Padded Armor', 5, 11, true, 8)
    , ((SELECT armor_id FROM armor WHERE name = 'Light Armor'), 'Leather Armor', 10, 11, false, 10)
    , ((SELECT armor_id FROM armor WHERE name = 'Light Armor'), 'Studded Leather Armor', 45, 12, false, 13)
;

INSERT INTO medium_armor(armor_id, name, cost, ac, stealth_disadvantage, weight)
VALUES ((SELECT armor_id FROM armor WHERE name = 'Medium Armor'), 'Hide Armor', 10, 12, false, 12)
    , ((SELECT armor_id FROM armor WHERE name = 'Medium Armor'), 'Chain Shirt', 50, 13, false, 20)
    , ((SELECT armor_id FROM armor WHERE name = 'Medium Armor'), 'Scale Mail', 50, 14, true, 45)
    , ((SELECT armor_id FROM armor WHERE name = 'Medium Armor'), 'Breastplate', 400, 14, false, 20)
    , ((SELECT armor_id FROM armor WHERE name = 'Medium Armor'), 'Half Plate Armor', 750, 15, true, 40)
;

INSERT INTO heavy_armor(armor_id, name, cost, ac, stealth_disadvantage, weight)
VALUES ((SELECT armor_id FROM armor WHERE name = 'Heavy Armor'), 'Ring Mail Armor', 30, 14, true, 40);
INSERT INTO heavy_armor(armor_id, name, cost, ac, strength_required, stealth_disadvantage, weight)
VALUES ((SELECT armor_id FROM armor WHERE name = 'Heavy Armor'), 'Chain Mail Armor', 75, 16, 13, true, 55)
    , ((SELECT armor_id FROM armor WHERE name = 'Heavy Armor'), 'Splint Armor', 200, 17, 15, true, 60)
    , ((SELECT armor_id FROM armor WHERE name = 'Heavy Armor'), 'Plate Armor', 1500, 18, 15, true, 65)
;

INSERT INTO shield(armor_id, name, cost, weight)
VALUES ((SELECT armor_id FROM armor WHERE name = 'Shield), 'Shield', 10, 6);

ALTER TABLE light_armor ADD CONSTRAINT FK_light_armor_armor FOREIGN KEY (armor_id) REFERENCES armor(armor_id);
ALTER TABLE medium_armor ADD CONSTRAINT FK_medium_armor_armor FOREIGN KEY (armor_id) REFERENCES armor(armor_id);
ALTER TABLE heavy_armor ADD CONSTRAINT FK_heavy_armor_armor FOREIGN KEY (armor_id) REFERENCES armor(armor_id);
ALTER TABLE shield ADD CONSTRAINT FK_shield_armor FOREIGN KEY (armor_id) REFERENCES armor(armor_id);

COMMIT;
