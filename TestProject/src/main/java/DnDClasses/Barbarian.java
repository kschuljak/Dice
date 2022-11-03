package DnDClasses;


public class Barbarian extends DnDClass {

    private int hitDie = 12;
    private String primaryAbility = "Strength";
    private String savingThrowProficiency1 = "Strength";
    private String savingThrowProficiency2 = "Constitution";
    private String[] armorAndWeaponProficiencies = new String[]{
            "Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"
    };

    private String[] barbarianSubclasses = new String[] {
            "berserker", "totem warrior"
    };

}
