public class Wizard {

    private int hitDie = 6;
    private String primaryAbility = "Intelligence";
    private String savingThrowProficiency1 = "Intelligence";
    private String savingThrowProficiency2 = "Wisdom";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Daggers", "Darts", "Slings", "Quarterstaffs", "Light Crossbows"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    };

}
