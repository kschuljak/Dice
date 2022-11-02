public class Warlock {

    private int hitDie = 8;
    private String primaryAbility = "Charisma";
    private String savingThrowProficiency1 = "Wisdom";
    private String savingThrowProficiency2 = "Charisma";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Light Armor", "Simple Weapons"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    };

}
