package Backpack.Gear.Weapons;

public class HeavyCrossbow extends Weapons{

    public HeavyCrossbow() {
        super("heavy crossbow", "50 gp","1d10 piercing", 18, "martial ranged weapon");
        properties.add("ammunition (range 100/400)");
        properties.add("heavy");
        properties.add("loading");
        properties.add("two-handed");
    }
}
