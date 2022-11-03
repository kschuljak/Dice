import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class AssignBackground {

    public static void main(String[] args) {


        String[] classOptions = new String[] {
                "DnDClasses.Barbarian", "DnDClasses.Bard", "DnDClasses.Cleric", "DnDClasses.Druid", "DnDClasses.Fighter", "DnDClasses.Monk",
                "DnDClasses.Paladin", "DnDClasses.Ranger", "DnDClasses.Rogue", "DnDClasses.Sorcerer", "DnDClasses.Warlock", "DnDClasses.Wizard"
        };


        String[] raceOptions = new String[] {
                "Dwarf", "Hill Dwarf", "Mountain Dwarf", "Elf", "High Elf", "Wood Elf",
                "Dark Elf", "Halfling", "Lightfoot Halfling", "Stout Halfling", "Human", "Dragonborn",
                "Gnome", "Forest Gnome", "Rock Gnome", "Half-Elf", "Half-Orc", "Tiefling"
        };



    }

    public static String randomArrayElement(String[] stringArray) {
        int max = stringArray.length;
        int randomIndex = (int)(Math.random() * max);
        return stringArray[randomIndex];
    }
}
