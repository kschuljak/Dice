package Backpack.Gear.Weapons;

public class HandCrossbow extends Weapons{

    public HandCrossbow() {
        super("hand crossbow", "75 GOLD","1d6 piercing", 3, "martial ranged weapon");
        properties.add("ammunition (range 30/120)");
        properties.add("light");
        properties.add("loading");
    }
}
