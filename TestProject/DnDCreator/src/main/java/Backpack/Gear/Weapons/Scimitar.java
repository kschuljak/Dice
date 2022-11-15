package Backpack.Gear.Weapons;

public class Scimitar extends Weapons{

    public Scimitar() {
        super("scimitar", "25 GOLD","1d6 slashing", 3, "martial melee weapon");
        properties.add("finesse");
        properties.add("light");
    }
}
