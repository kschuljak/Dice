package Backpack.Gear.Weapons;

public class Rapier extends Weapons{

    public Rapier() {
        super("rapier", "25 gp","1d8 piercing", 2, "martial melee weapon");
        properties.add("finesse");
    }
}
