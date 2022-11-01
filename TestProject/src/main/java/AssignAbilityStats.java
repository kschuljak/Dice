import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AssignAbilityStats {

    public static void main(String[] args) {

        printHeader();

        // creates array of strings for standard D&D ability status
        String[] standardAbilityStats = new String[6];
        standardAbilityStats[0] = "strength";
        standardAbilityStats[1] = "dexterity";
        standardAbilityStats[2] = "constitution";
        standardAbilityStats[3] = "intelligence";
        standardAbilityStats[4] = "wisdom";
        standardAbilityStats[5] = "charisma";

        // lists standard ability stats to the console
        System.out.println("The standard D&D ability stats are:");

        // enhanced for loop
        // == for (int i = 0; i < standardAbilityStats.length; i++) {print standardAbilityStat[i]}
        for (String standardAbilityStat : standardAbilityStats) {
            System.out.println(standardAbilityStat);
        }

        // creates array of integers for standard D&D ability scores
        int[] standardAbilityScoreValues = new int[]{8, 10, 12, 13, 14, 15};
        System.out.println();
        System.out.println("The standard D&D ability score values are:");

        // enhanced for loop
        //== for (int i = 0; i < standardAbilityScoreValues.length; i++) {print standardAbilityScoreValues[i])
        for (int standardAbilityScoreValue : standardAbilityScoreValues) {
            System.out.println(standardAbilityScoreValue);
        }

        printSpacer();

        System.out.println("Your randomly assigned stats are:");
        // call assignStandardAbilityScores()
        // function loops through stats & shuffled list to print assigned values
        assignStandardAbilityScores(standardAbilityStats);

        printFooter();
    }

    // randomly shuffle list elements using Collections class shuffle() method
    //      reference: digitalocean.com/community/tutorials/shuffle-array-java
    //      reference: javatpoint.com/java-collections-shuffle-method
    static Integer[] reorderStandardAbilityScoreValues() {
        List<Integer> list = Arrays.asList(8, 10, 12, 13, 14, 15);
        Collections.shuffle(list);
        return list.toArray(new Integer[0]);
    }

    // increment through standardAbilityStats[] and newShuffledList[] arrays
    // for each, print element at that index as stat (standardAbilityStats[i]) and randomly assigned value (newShuffledList[i])
    public static void assignStandardAbilityScores(String[] standardAbilityStats) {
        Integer[] newShuffledList = reorderStandardAbilityScoreValues();
        for (int i = 0; i < standardAbilityStats.length; i++) {
            System.out.println(standardAbilityStats[i] + ": " + newShuffledList[i]);
        }
    }

    private static void printHeader() {
        System.out.println();
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("*** Randomly Assign Your Character Stats ***");
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println();
    }

    private static void printSpacer() {
        System.out.println();
        System.out.println("********************************************");
        System.out.println();
    }

    private static void printFooter() {
        System.out.println();
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("*** Thank you, and have fun playing D&D! ***");
        System.out.println("********************************************");
        System.out.println("********************************************");
    }






}
