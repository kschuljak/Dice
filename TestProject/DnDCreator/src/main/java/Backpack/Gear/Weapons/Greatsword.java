package Backpack.Gear.Weapons;

public class Greatsword extends Weapons{

    public Greatsword() {
        super("greatsword", "50 GOLD","2d6 slashing", 6, "martial melee weapon");
        properties.add("heavy");
        properties.add("two-handed");
    }
}
