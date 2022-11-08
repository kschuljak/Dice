package DnDClasses;

public class Wizard extends DnDClass{

    public Wizard() {

        super("Wizard", 6, "Intelligence", "Intelligence", "Wisdom");

        setArmorAndWeaponProficiencies(new String[] {"Daggers", "Darts", "Slings", "Quarterstaffs", "Light Crossbows"});

    }

}
