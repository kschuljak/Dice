package Assignments;

public class AssignBackground {

    public static void assignBackground() {


        String[] classOptions = new String[]{
                "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
                "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"
        };
        System.out.println();
        String classSelected = randomArrayElement(classOptions);
        System.out.println(classSelected);


        String[] raceOptions = new String[]{
                "Dwarf", "Hill Dwarf", "Mountain Dwarf", "Elf", "High Elf", "Wood Elf",
                "Dark Elf", "Halfling", "Lightfoot Halfling", "Stout Halfling", "Human", "Dragonborn",
                "Gnome", "Forest Gnome", "Rock Gnome", "Half-Elf", "Half-Orc", "Tiefling"
        };
        System.out.println();
        String raceSelected = randomArrayElement(raceOptions);
        System.out.println(raceSelected);


    }

    public static String randomArrayElement(String[] stringArray) {
        int max = stringArray.length;
        int randomIndex = (int) (Math.random() * max);
        return stringArray[randomIndex];
    }
}
