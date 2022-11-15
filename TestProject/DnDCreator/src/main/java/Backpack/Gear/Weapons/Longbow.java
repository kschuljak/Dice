package Backpack.Gear.Weapons;

public class Longbow extends Weapons{

    public Longbow() {
        super("longbow", "50 GOLD","1d8 piercing", 2, "martial ranged weapon");
        properties.add("ammunition (range 150/600)");
        properties.add("heavy");
        properties.add("two-handed");
    }
}
