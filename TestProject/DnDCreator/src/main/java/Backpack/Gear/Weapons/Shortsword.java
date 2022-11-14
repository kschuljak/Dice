package Backpack.Gear.Weapons;

public class Shortsword extends Weapons{

    public Shortsword() {
        super("shortsword", "10 gp","1d6 piercing", 2, "martial melee weapon");
        properties.add("finesse");
        properties.add("light");
    }
}
