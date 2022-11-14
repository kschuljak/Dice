package Backpack.Gear.Weapons;

public class Improvised extends Weapons{

    public Improvised() {
        super("improvised", "", "1d4 (type chosen by DM)", 0, "improvised weapon");
        properties.add("thrown (range 20/ 60)");
    }
}
