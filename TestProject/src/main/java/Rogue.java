public class Rogue {

    private int hitDie = 8;
    private String primaryAbility = "Dexterity";
    private String savingThrowProficiency1 = "Dexterity";
    private String savingThrowProficiency2 = "Intelligence";
    private String[] armorAndWeaponProficiencies = new String[] {
            "Light Armor", "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers", "Shortswords"
    };

    public int level;

    public void setLevel(int level) {
        this.level = level;
    };

}
