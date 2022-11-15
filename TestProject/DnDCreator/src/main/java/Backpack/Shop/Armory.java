package Backpack.Shop;

public class Armory extends Shop{

    protected String[] gearInShopSimpleMeleeWeapons = new String[]{};
    protected String[] gearInShopSimpleRangedWeapons = new String[]{};
    protected String[] gearInShopMartialMeleeWeapons = new String[]{};
    protected String[] gearInShopMartialRangedWeapons = new String[]{};

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
}
