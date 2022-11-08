package DnDClasses;

public class Rogue extends DnDClass {

    public Rogue() {

        super("Rogue", 8, "Dexterity", "Dexterity", "Intelligence");

        setArmorAndWeaponProficiencies(new String[] {"Light Armor", "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers", "Shortswords"});

    }

}
