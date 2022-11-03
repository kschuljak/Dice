import java.util.Map;
import java.util.HashMap;

public class DnDClass {


    public int level;
    public String subclass;
    public int hitDie;
    public String primaryAbility;
    public String savingThrowProficiency1;
    public String savingThrowProficiency2;
    public String[] armorAndWeaponProficiencies = new String[]{};


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

        Map<String, Integer> hitDiceByClass = new HashMap<>();
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


}
