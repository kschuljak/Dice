package DnDClasses;

public class Paladin extends DnDClass {

    public Paladin() {

        super("Paladin", 10, "Strength and Charisma", "Wisdom", "Charisma");

        setArmorAndWeaponProficiencies(new String[]{"Light Armor", "Medium Armor", "Heavy Armor", "Shields", "Simple Weapons", "Martial Weapons"});

    }

}
