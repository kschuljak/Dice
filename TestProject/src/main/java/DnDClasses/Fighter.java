package DnDClasses;

public class Fighter extends DnDClass {

    private int hitDie = 10;
    private String primaryAbility = "Strength";   // or dexterity
    private String savingThrowProficiency1 = "Strength";
    private String savingThrowProficiency2 = "Constitution";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Light Armor", "Medium Armor", "Heavy Armor", "Shields", "Simple Weapons", "Martial Weapons"
    };

}
