package Backpack.Gear.Weapons;

public class Greataxe extends Weapons{

    public Greataxe() {
        super("greataxe", "30 gp","1d12 slashing", 7, "martial melee weapon");
        properties.add("heavy");
        properties.add("two-handed");
    }
}
