package Backpack.Gear.Weapons;

public class Lance extends Weapons{

    public Lance() {
        super("lance", "10 GOLD","1d12 piercing", 6, "martial melee weapon");
        properties.add("reach");
        properties.add("special - disadvantage against a target within 5 feet");
        properties.add("special - two-handed if not mounted");
    }
}
