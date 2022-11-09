package DnDClasses;

public class Monk extends DnDClass {

    public Monk() {

        super("Monk", 8, "Dexterity and Wisdom", "Strength", "Dexterity");

        setArmorAndWeaponProficiencies(new String[]{"Simple Weapons", "Shortswords"});

    }

}
