package Backpack.Gear.Weapons;

public class Blowgun extends Weapons{

    public Blowgun() {
        super("blowgun", "10 gp","1 piercing", 1, "martial ranged weapon");
        properties.add("ammunition (range 25/100)");
        properties.add("loading");
    }
}
