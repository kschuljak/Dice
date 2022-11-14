package Backpack.Gear.Weapons;

public class LightCrossbow extends Weapons{

    public LightCrossbow() {
        super("light crossbow", "25 gp", "1d8 piercing", 5, "simple ranged weapon");
        properties.add("ammunition (range 80/320");
        properties.add("loading");
        properties.add("two-handed");
    }
}
