package DnDClasses;

public class Sorcerer extends DnDClass {

    public Sorcerer() {

        super("Sorcerer", 6, "Charisma", "Constitution", "Charisma");

        setArmorAndWeaponProficiencies(new String[]{"Daggers", "Darts", "Slings", "Quarterstaffs", "Light Crossbows"});

    }

}
