public class Sorcerer {

    private int hitDie = 6;
    private String primaryAbility = "Charisma";
    private String savingThrowProficiency1 = "Constitution";
    private String savingThrowProficiency2 = "Charisma";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Daggers", "Darts", "Slings", "Quarterstaffs", "Light Crossbows"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    };

}
