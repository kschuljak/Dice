package DnDClasses;

public abstract class DnDClass {

    // instance variables
    private String dndClassName;
    private int level;
    private String subclass;
    private String[] subclassOptions = new String[]{};
    private int hitDie;
    private String primaryAbility;
    private String savingThrowProficiency1;
    private String savingThrowProficiency2;
    private String[] armorAndWeaponProficiencies = new String[]{};

    // constructor
    public DnDClass() {
    }

    public DnDClass(String dndClassName, int hitDie, String primaryAbility, String savingThrowProficiency1, String savingThrowProficiency2) {
        this.dndClassName = dndClassName;
        this.hitDie = hitDie;
        this.primaryAbility = primaryAbility;
        this.savingThrowProficiency1 = savingThrowProficiency1;
        this.savingThrowProficiency2 = savingThrowProficiency2;
    }

    // dnd class name - getter and setter
    public String getDndClassName() {
        return dndClassName;
    }

    public void setDndClassName(String dndClassName) {
        this.dndClassName = dndClassName;
    }

    // level - getter and setter
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // subclass - getter and setter
    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    // subclass options - getter and setter
    public String[] getSubclassOptions() {
        return subclassOptions;
    }

    public void setSubclassOptions(String[] subclassOptions) {
        this.subclassOptions = subclassOptions;
    }

    // primary ability - getter and setter
    public String getPrimaryAbility() {
        return primaryAbility;
    }

    public void setPrimaryAbility(String primaryAbility) {
        this.primaryAbility = primaryAbility;
    }

    // saving throw proficiency 1 - getter and setter
    public String getSavingThrowProficiency1() {
        return savingThrowProficiency1;
    }

    public void setSavingThrowProficiency1(String savingThrowProficiency1) {
        this.savingThrowProficiency1 = savingThrowProficiency1;
    }

    // saving throw proficiency 2 - getter and setter
    public String getSavingThrowProficiency2() {
        return savingThrowProficiency2;
    }

    public void setSavingThrowProficiency2(String savingThrowProficiency2) {
        this.savingThrowProficiency2 = savingThrowProficiency2;
    }

    // armor and weapon proficiencies - getter and setter
    public String[] getArmorAndWeaponProficiencies() {
        return armorAndWeaponProficiencies;
    }

    public void setArmorAndWeaponProficiencies(String[] armorAndWeaponProficiencies) {
        this.armorAndWeaponProficiencies = armorAndWeaponProficiencies;
    }

    // hit die - getter and setter
    public int getHitDie() {
        return hitDie;
    }

    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }
}

