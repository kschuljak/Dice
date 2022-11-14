package Backpack.Gear.Weapons;

public class Trident extends Weapons{

    public Trident() {
        super("trident", "5 gp","1d6 piercing", 4, "martial melee weapon");
        properties.add("thrown (range 20/60)");
        properties.add("versatile (1d8)");
    }
}
