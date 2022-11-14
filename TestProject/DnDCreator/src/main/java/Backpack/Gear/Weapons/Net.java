package Backpack.Gear.Weapons;

public class Net extends Weapons{

    public Net() {
        super("net", "1 gp","", 3, "martial ranged weapon");
        properties.add("thrown (range 5/15)");
        properties.add("special - restrains a creature size Large or smaller until freed; has no effect on formless creatures, or creatures size Huge or larger");
        properties.add("special - a creature can use its action to make a DC 10 Strength check to free itself or another creature");
        properties.add("special - dealing 5 slashing damage to net frees a creature without harm and destroys the net");
        properties.add("special - when using an action, bonus action, or reaction to attack with a new, that is the only attack you can make that turn");
    }
}
