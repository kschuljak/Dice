public class Bard {

    private int hitDie = 8;
    private String primaryAbility = "Charisma";
    private String savingThrowProficiency1 = "Dexterity";
    private String savingThrowProficiency2 = "Charisma";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Light Armor", "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers", "Shortswords"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    };
}
