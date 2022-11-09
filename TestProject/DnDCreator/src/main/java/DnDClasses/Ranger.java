package DnDClasses;

public class Ranger extends DnDClass {

    public Ranger() {

        super("Ranger", 10, "Dexterity and Wisdom", "Strength", "Dexterity");

        setArmorAndWeaponProficiencies(new String[] {"Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"});

    }

}
