package DnDClasses;

public class Barbarian extends DnDClass {

    public Barbarian() {

        super("Barbarian", 12, "Strength", "Strength", "Constitution");

        setArmorAndWeaponProficiencies(new String[]{"Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"});

        setSubclassOptions(new String[]{"Berserker", "Totem Warrior"});

    }

}
