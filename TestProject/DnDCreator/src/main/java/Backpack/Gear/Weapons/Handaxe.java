package Backpack.Gear.Weapons;

public class Handaxe extends Weapons{

    public Handaxe() {
        super("handaxe", "5 GOLD", "1d6 slashing", 2, "simple melee weapon");
        properties.add("light");
        properties.add("thrown(range 20/60");
    }
}
