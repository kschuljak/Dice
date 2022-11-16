package Backpack.Shop;

import Backpack.Coinpurse.Coinpurse;
import Backpack.Gear.Weapons.*;

import java.util.HashMap;
import java.util.Map;

public class Armory extends Shop{

    protected String[] gearInShopSimpleMeleeWeapons = new String[]{"Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Hammer(Light)", "Mace", "Quarterstaff", "Sickle", "Spear"};
    protected String[] gearInShopSimpleRangedWeapons = new String[]{"Crossbow(Light)", "Dart", "Shortbow", "Sling"};
    protected String[] gearInShopMartialMeleeWeapons = new String[]{"Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance", "Longsword", "Maul", "Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War Pick", "Warhammer", "Whip"};
    protected String[] gearInShopMartialRangedWeapons = new String[]{"Blowgun", "Crossbow(Hand)", "Crossbow(Heavy)", "Longbow", "Net"};

    public String[] getGearInShopSimpleMeleeWeapons() {
        return gearInShopSimpleMeleeWeapons;
    }

    public String[] getGearInShopSimpleRangedWeapons() {
        return gearInShopSimpleRangedWeapons;
    }

    public String[] getGearInShopMartialMeleeWeapons() {
        return gearInShopMartialMeleeWeapons;
    }

    public String[] getGearInShopMartialRangedWeapons() {
        return gearInShopMartialRangedWeapons;
    }

    @Override
    public String[] getGearInShop(){
        int gearOptionsInShop = gearInShopSimpleMeleeWeapons.length + gearInShopSimpleRangedWeapons.length + gearInShopMartialMeleeWeapons.length + gearInShopMartialRangedWeapons.length;
        String[] gearInShop = new String[gearOptionsInShop];
        int i = 0;
        for (String item : gearInShopSimpleMeleeWeapons) {
            gearInShop[i] = item;
            i++;
        }
        for (String item : gearInShopSimpleRangedWeapons) {
            gearInShop[i] = item;
            i++;
        }
        for (String item : gearInShopMartialMeleeWeapons) {
            gearInShop[i] = item;
            i++;
        }
        for (String item : gearInShopMartialRangedWeapons) {
            gearInShop[i] = item;
            i++;
        }
        return gearInShop;
    }

    public void printGear(){
        String[] gearOptions = getGearInShop();
        int selection = 1;
        for (String option : gearOptions){
            System.out.println(selection + ") " + option);
            selection++;
        }
        System.out.println();
    }

    public void printSimpleMeleeWeapons(){
        String[] gearOptions = getGearInShopSimpleMeleeWeapons();
        int selection = 1;
        for (String option : gearOptions){
            System.out.println(selection + ") " + option);
            selection++;
        }
        System.out.println();
    }

    public void printSimpleRangedWeapons(){
        String[] gearOptions = getGearInShopSimpleRangedWeapons();
        int selection = 1;
        for (String option : gearOptions){
            System.out.println(selection + ") " + option);
            selection++;
        }
        System.out.println();
    }

    public void printMartialMeleeWeapons(){
        String[] gearOptions = getGearInShopMartialMeleeWeapons();
        int selection = 1;
        for (String option : gearOptions){
            System.out.println(selection + ") " + option);
            selection++;
        }
        System.out.println();
    }

    public void printMartialRangedWeapons(){
        String[] gearOptions = getGearInShopMartialRangedWeapons();
        int selection = 1;
        for (String option : gearOptions){
            System.out.println(selection + ") " + option);
            selection++;
        }
        System.out.println();
    }

    public Weapons getSelection(int i, String[] listOption) {
        Map<String, Weapons> weaponsMap = WeaponObjects.createMap();
        Weapons item = null;
        if (weaponsMap.containsKey(listOption[i - 1])) {
            item = weaponsMap.get(listOption[i - 1]);
        }
        return item;
    }


}
