package DnDClasses;

public class Fighter extends DnDClass {

    public Fighter() {

        super("Fighter", 10, "Strength or Dexterity", "Strength", "Constitution");

        setArmorAndWeaponProficiencies(new String[]{"Light Armor", "Medium Armor", "Heavy Armor", "Shields", "Simple Weapons", "Martial Weapons"});

    }

}
