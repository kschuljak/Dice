package Backpack.Shop;

import Backpack.Gear.Weapons.*;

import java.util.HashMap;
import java.util.Map;

public class WeaponObjects {

    // simple melee weapons
    Club club = new Club();
    Dagger dagger = new Dagger();
    Greatclub greatclub = new Greatclub();
    Handaxe handaxe = new Handaxe();
    Javelin javelin = new Javelin();
    LightHammer lightHammer = new LightHammer();
    Mace mace = new Mace();
    Quarterstaff quarterstaff = new Quarterstaff();
    Sickle sickle = new Sickle();
    Spear spear = new Spear();

    // simple ranged weapons
    LightCrossbow lightCrossbow = new LightCrossbow();
    Dart dart = new Dart();
    Shortbow shortbow = new Shortbow();
    Sling sling = new Sling();

    // martial melee weapons
    Battleaxe battleaxe = new Battleaxe();
    Flail flail = new Flail();
    Glaive glaive = new Glaive();
    Greataxe greataxe = new Greataxe();
    Greatsword greatsword = new Greatsword();
    Halberd halberd = new Halberd();
    Lance lance = new Lance();
    Longsword longsword = new Longsword();
    Maul maul = new Maul();
    Morningstar morningstar = new Morningstar();
    Pike pike = new Pike();
    Rapier rapier = new Rapier();
    Scimitar scimitar = new Scimitar();
    Shortsword shortsword = new Shortsword();
    Trident trident = new Trident();
    WarPick warPick = new WarPick();
    Warhammer warhammer = new Warhammer();
    Whip whip = new Whip();

    // martial ranged weapons
    Blowgun blowgun = new Blowgun();
    HandCrossbow handCrossbow = new HandCrossbow();
    HeavyCrossbow heavyCrossbow = new HeavyCrossbow();
    Longbow longbow = new Longbow();
    Net net = new Net();

    public Club getClub() {
        return club;
    }

    public Dagger getDagger() {
        return dagger;
    }

    public Greatclub getGreatclub() {
        return greatclub;
    }

    public Handaxe getHandaxe() {
        return handaxe;
    }

    public Javelin getJavelin() {
        return javelin;
    }

    public LightHammer getLightHammer() {
        return lightHammer;
    }

    public Mace getMace() {
        return mace;
    }

    public Quarterstaff getQuarterstaff() {
        return quarterstaff;
    }

    public Sickle getSickle() {
        return sickle;
    }

    public Spear getSpear() {
        return spear;
    }

    public LightCrossbow getLightCrossbow() {
        return lightCrossbow;
    }

    public Dart getDart() {
        return dart;
    }

    public Shortbow getShortbow() {
        return shortbow;
    }

    public Sling getSling() {
        return sling;
    }

    public Battleaxe getBattleaxe() {
        return battleaxe;
    }

    public Flail getFlail() {
        return flail;
    }

    public Glaive getGlaive() {
        return glaive;
    }

    public Greataxe getGreataxe() {
        return greataxe;
    }

    public Greatsword getGreatsword() {
        return greatsword;
    }

    public Halberd getHalberd() {
        return halberd;
    }

    public Lance getLance() {
        return lance;
    }

    public Longsword getLongsword() {
        return longsword;
    }

    public Maul getMaul() {
        return maul;
    }

    public Morningstar getMorningstar() {
        return morningstar;
    }

    public Pike getPike() {
        return pike;
    }

    public Rapier getRapier() {
        return rapier;
    }

    public Scimitar getScimitar() {
        return scimitar;
    }

    public Shortsword getShortsword() {
        return shortsword;
    }

    public Trident getTrident() {
        return trident;
    }

    public WarPick getWarPick() {
        return warPick;
    }

    public Warhammer getWarhammer() {
        return warhammer;
    }

    public Whip getWhip() {
        return whip;
    }

    public Blowgun getBlowgun() {
        return blowgun;
    }

    public HandCrossbow getHandCrossbow() {
        return handCrossbow;
    }

    public HeavyCrossbow getHeavyCrossbow() {
        return heavyCrossbow;
    }

    public Longbow getLongbow() {
        return longbow;
    }

    public Net getNet() {
        return net;
    }

    public static Map<String, Weapons> createMap() {

        Map<String, Weapons> weaponObjectMap = new HashMap<>();

        weaponObjectMap.put("Club", new Club());
        weaponObjectMap.put("Dagger", new Dagger());
        weaponObjectMap.put("Greatclub", new Greatclub());
        weaponObjectMap.put("Handaxe", new Handaxe());
        weaponObjectMap.put("Javelin", new Javelin());
        weaponObjectMap.put("Hammer(Light)", new LightHammer());
        weaponObjectMap.put("Mace", new Mace());
        weaponObjectMap.put("Quarterstaff", new Quarterstaff());
        weaponObjectMap.put("Sickle", new Sickle());
        weaponObjectMap.put("Spear", new Spear());

        weaponObjectMap.put("Crossbow(Light)", new LightCrossbow());
        weaponObjectMap.put("Dart", new Dart());
        weaponObjectMap.put("Shortbow", new Shortbow());
        weaponObjectMap.put("Sling", new Sling());

        weaponObjectMap.put("Battleaxe", new Battleaxe());
        weaponObjectMap.put("Flail", new Flail());
        weaponObjectMap.put("Glaive", new Glaive());
        weaponObjectMap.put("Greataxe", new Greataxe());
        weaponObjectMap.put("Greatsword", new Greatsword());
        weaponObjectMap.put("Halberd", new Halberd());
        weaponObjectMap.put("Lance", new Lance());
        weaponObjectMap.put("Longsword", new Longsword());
        weaponObjectMap.put("Maul", new Maul());
        weaponObjectMap.put("Morningstar", new Morningstar());
        weaponObjectMap.put("Pike", new Pike());
        weaponObjectMap.put("Rapier", new Rapier());
        weaponObjectMap.put("Scimitar", new Scimitar());
        weaponObjectMap.put("Shortsword", new Shortsword());
        weaponObjectMap.put("Trident", new Trident());
        weaponObjectMap.put("War Pick", new WarPick());
        weaponObjectMap.put("Warhammer", new Warhammer());
        weaponObjectMap.put("Whip", new Whip());

        weaponObjectMap.put("Blowgun", new Blowgun());
        weaponObjectMap.put("Crossbow(Hand)", new HandCrossbow());
        weaponObjectMap.put("Crossbow(Heavy)", new HeavyCrossbow());
        weaponObjectMap.put("Longbow", new Longbow());
        weaponObjectMap.put("Net", new Net());

        return weaponObjectMap;
    }
}
