package Backpack.Gear.Weapons;

public class Spear extends Weapons{

    public Spear() {
        super("spear", "1 GOLD", "1d6 piercing", 3, "simple melee weapon");
        properties.add("thrown (range 20/60)");
        properties.add("versatile (1d8)");
    }
}
