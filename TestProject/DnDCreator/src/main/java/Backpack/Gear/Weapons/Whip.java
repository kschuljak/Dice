package Backpack.Gear.Weapons;

public class Whip extends Weapons{

    public Whip() {
        super("whip", "2 GOLD","1d4 slashing", 3, "martial melee weapon");
        properties.add("finesse");
        properties.add("reach");
    }
}
