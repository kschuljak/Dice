package DnDClasses;

public class Warlock extends DnDClass {

    public Warlock() {

        super("Warlock", 8, "Charisma", "Wisdom", "Charisma");

        setArmorAndWeaponProficiencies(new String[]{"Light Armor", "Simple Weapons"});

    }

}
