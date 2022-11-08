package DnDClasses;

public class Druid extends DnDClass {

    public Druid() {

        super("Druid", 8, "Wisdom", "Intelligence", "Wisdom");

        setArmorAndWeaponProficiencies(new String[] { "Light Armor (nonmetal)", "Medium Armor (nonmetal)", "Shields", "Clubs", "Daggers", "Darts", "Javelins", "Maces", "Quarterstaffs", "Scimitars", "Sickles", "Slings", "Spears"});

    }

}
