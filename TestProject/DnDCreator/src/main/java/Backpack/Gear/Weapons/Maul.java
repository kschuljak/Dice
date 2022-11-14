package Backpack.Gear.Weapons;

public class Maul extends Weapons{

    public Maul() {
        super("maul", "10 gp","2d6 bludgeoning", 10, "martial melee weapon");
        properties.add("heavy");
        properties.add("two-handed");
    }
}
