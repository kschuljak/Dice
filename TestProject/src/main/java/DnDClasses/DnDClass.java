package DnDClasses;

import java.util.Map;
import java.util.HashMap;

public class DnDClass {

    // instance variables
    private int level;
    private String subclass;
    private int hitDie;
    private String primaryAbility;
    private String savingThrowProficiency1;
    private String savingThrowProficiency2;
    private String[] armorAndWeaponProficiencies = new String[]{};

    // setters
    public void setLevel(int level) {
        this.level = level;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public void setPrimaryAbility(String primaryAbility){
        this.primaryAbility = primaryAbility;
    }

    public void setSavingThrowProficiency1(String savingThrowProficiency1){
        this.savingThrowProficiency1 = savingThrowProficiency1;
    }

    public void setSavingThrowProficiency2(String savingThrowProficiency2){
        this.savingThrowProficiency2 = savingThrowProficiency2;
    }

    public void setArmorAndWeaponProficiencies(String[] armorAndWeaponProficiencies){
        this.armorAndWeaponProficiencies = armorAndWeaponProficiencies;
    }

    public void setHitDie(String classDnD){

        Map<String, Integer> hitDiceByClass = new HashMap<>(13);
        // (key = DnD class, value = die type )
        hitDiceByClass.put("barbarian", 12);
        hitDiceByClass.put("fighter", 10);
        hitDiceByClass.put("paladin", 10);
        hitDiceByClass.put("ranger", 10);
        hitDiceByClass.put("artificer", 8);
        hitDiceByClass.put("bard", 8);
        hitDiceByClass.put("cleric", 8);
        hitDiceByClass.put("druid", 8);
        hitDiceByClass.put("monk", 8);
        hitDiceByClass.put("rogue", 8);
        hitDiceByClass.put("warlock",8);
        hitDiceByClass.put("sorcerer", 6);
        hitDiceByClass.put("wizard", 6);

        for (Map.Entry<String, Integer> row : hitDiceByClass.entrySet()) {
            if (row.getKey().equals(classDnD)) {
                hitDie = row.getValue();
            }
        }
    }

    // getters
    public int getLevel() {
        return this.level;
    }

    public String getSubclass() {
        return this.subclass;
    }

    public int getHitDie() {
        return this.hitDie;
    }

    public String getPrimaryAbility() {
        return this.primaryAbility;
    }

    public String getSavingThrowProficiency1() {
        return this.savingThrowProficiency1;
    }

    public String getSavingThrowProficiency2() {
        return this.savingThrowProficiency2;
    }

    public String[] getArmorAndWeaponProficiencies() {
        return this.armorAndWeaponProficiencies;
    }

}

