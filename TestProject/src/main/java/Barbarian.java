public class Barbarian {

    private int hitDie = 12;
    private String primaryAbility = "Strength";
    private String savingThrowProficiency1 = "Strength";
    private String savingThrowProficiency2 = "Constitution";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    }
}
