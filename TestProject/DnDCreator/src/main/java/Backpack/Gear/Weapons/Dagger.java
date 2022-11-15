package Backpack.Gear.Weapons;

public class Dagger extends Weapons{

    public Dagger() {
        super("dagger", "2 GOLD", "1d4 piercing", 1, "simple melee weapon");
        properties.add("finesse");
        properties.add("light");
        properties.add("thrown (range 20/60");
    }
}
