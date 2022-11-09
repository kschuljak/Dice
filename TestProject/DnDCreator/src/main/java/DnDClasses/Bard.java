package DnDClasses;

public class Bard extends DnDClass {

    public Bard() {

        super("Bard", 8, "Charisma", "Dexterity", "Charisma");

        setArmorAndWeaponProficiencies(new String[]{"Light Armor", "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers", "Shortswords"});

    }

}
