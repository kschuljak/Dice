package Backpack.Gear.Weapons;

public class Halberd extends Weapons{

    public Halberd() {
        super("halberd", "20 gp","1d10 slashing", 6, "martial melee weapon");
        properties.add("heavy");
        properties.add("reach");
        properties.add("two-handed");
    }
}
