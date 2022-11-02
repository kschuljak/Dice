public class Druid {

    private int hitDie = 8;
    private String primaryAbility = "Wisdom";
    private String savingThrowProficiency1 = "Intelligence";
    private String savingThrowProficiency2 = "Wisdom";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Light Armor (nonmetal)", "Medium Armor (nonmetal)", "Shields", "Clubs", "Daggers", "Darts",
            "Javelins", "Maces", "Quarterstaffs", "Scimitars", "Sickles", "Slings", "Spears"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    };

}
