package Backpack.Gear.Weapons;

public class Shortbow extends Weapons{

    public Shortbow() {
        super("shortbow", "25 gp", "1d6 piercing", 2, "simple ranged weapon");
        properties.add("ammunition (range 80/320");
        properties.add("two-handed");
    }
}
