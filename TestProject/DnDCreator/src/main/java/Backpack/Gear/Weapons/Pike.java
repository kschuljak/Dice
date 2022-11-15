package Backpack.Gear.Weapons;

public class Pike extends Weapons{

    public Pike() {
        super("pike", "5 GOLD","1d10 piercing", 18, "martial melee weapon");
        properties.add("heavy");
        properties.add("reach");
        properties.add("two-handed");
    }
}
