package DnDClasses;

public class Cleric extends DnDClass {

    public Cleric() {

        super("Cleric", 8, "Wisdom", "Wisdom", "Charisma");

        setArmorAndWeaponProficiencies(new String[] {"Light Armor", "Medium Armor", "Shields", "Simple Weapons"});

    }

}
