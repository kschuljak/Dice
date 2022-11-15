package Backpack.Gear.Weapons;

public class LightHammer extends Weapons{

    public LightHammer() {
        super("light hammer", "2 GOLD", "1d4 bludgeoning", 2, "simple melee weapon");
        properties.add("light");
        properties.add("thrown (range 20/60)");
    }
}
