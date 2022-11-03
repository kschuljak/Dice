public class Barbarian extends DnDClass{



    public void main(String[] args) {

        DnDClass Barbarian = new DnDClass();
        setHitDie("barbarian");
        System.out.println("hit die = " + hitDie);

        setPrimaryAbility("strength");
        setSavingThrowProficiency1("strength");
        setSavingThrowProficiency2("constitution");
        setArmorAndWeaponProficiencies(barbarianWeaponsArmorProficiencies);


    }

    public String[] barbarianSubclass = new String[] {
            "berserker", "totem warrior"
    };

    public String[] barbarianWeaponsArmorProficiencies = new String[] {
            "light armor", "medium armor", "shields", "simple weapons", "martial weapons"
    };







//    private int hitDie = 12;
//    private String primaryAbility = "Strength";
//    private String savingThrowProficiency1 = "Strength";
//    private String savingThrowProficiency2 = "Constitution";
//    private String[] armorAndWeaponProficiencies = new String[] {
//            "Light Armor", "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"
//    };


}
