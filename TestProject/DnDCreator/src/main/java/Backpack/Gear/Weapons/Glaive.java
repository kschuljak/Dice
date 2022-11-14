package Backpack.Gear.Weapons;

public class Glaive extends Weapons{

    public Glaive() {
        super("glaive", "20 gp","1d10 slashing", 6, "martial melee weapon");
        properties.add("heavy");
        properties.add("reach");
        properties.add("two-handed");
    }
}
