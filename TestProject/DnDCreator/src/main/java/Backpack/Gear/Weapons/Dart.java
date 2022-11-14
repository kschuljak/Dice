package Backpack.Gear.Weapons;

public class Dart extends Weapons{

    public Dart() {
        super("dart", "5 cp", "1d4 piercing", 0.25, "simple ranged weapon");
        properties.add("finesse");
        properties.add("thrown (range 20/60");
    }
}
