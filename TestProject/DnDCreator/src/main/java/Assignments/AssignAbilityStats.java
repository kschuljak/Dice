package Assignments;

import java.util.*;

public class AssignAbilityStats {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        printHeader();

        // creates array of strings for standard D&D ability status
        String[] standardAbilityStats = new String[6];
        standardAbilityStats[0] = "strength";
        standardAbilityStats[1] = "dexterity";
        standardAbilityStats[2] = "constitution";
        standardAbilityStats[3] = "intelligence";
        standardAbilityStats[4] = "wisdom";
        standardAbilityStats[5] = "charisma";

        // creates array of integers for standard D&D ability scores
        int[] standardAbilityScoreValues = new int[]{8, 10, 12, 13, 14, 15};

        printSpacer();

        System.out.println("Your randomly assigned stats are:");
        // call assignStandardAbilityScores()
        // function loops through stats & shuffled list to print assigned values
        assignStandardAbilityScores(standardAbilityStats);

        printSpacer();

        System.out.println("Your randomly rolled stats are:");
        assignRolledAbilityScores(standardAbilityStats);

        printFooter();
    }

    // randomly shuffle list elements using Collections class shuffle() method
    // creates list from int array
    // uses .shuffle() method to randomly reorder list
    // returns int array created from shuffled list
    static Integer[] shuffleStandardAbilityScores() {
        List<Integer> shuffledScoreValues = Arrays.asList(8, 10, 12, 13, 14, 15);
        Collections.shuffle(shuffledScoreValues);
        return shuffledScoreValues.toArray(new Integer[0]);
    }

    // increment through standardAbilityStats[] and newShuffledList[] arrays
    // for each, print element at that index as stat (standardAbilityStats[i]) and randomly assigned value (newShuffledList[i])
    public static void assignStandardAbilityScores(String[] standardAbilityStats) {
        Integer[] newShuffledList = shuffleStandardAbilityScores();
        for (int i = 0; i < standardAbilityStats.length; i++) {
            System.out.println(standardAbilityStats[i] + ": " + newShuffledList[i]);
        }
    }

    // roll 4 d6 and add each roll to list
    // sort list and ignore the lowest roll (at index 0)
    // add scores at indexes 1, 2, and 3
    // return total score
    public static int rollForStat() {
        List<Integer> fourRolls = new ArrayList<>(4);
        // roll d6 x 4
        for (int i = 4; i > 0; i--) fourRolls.add(rollD6());
        Collections.sort(fourRolls);
        int totalScore = 0;
        for (int i = 1; i < 4; i++) {
            totalScore += fourRolls.get(i);
        }
        return totalScore;
    }

    public static void assignRolledAbilityScores(String[] standardAbilityStats) {
        for (String standardAbilityStat : standardAbilityStats) {
            int totalRoll = rollForStat();
            System.out.println(standardAbilityStat + ": " + totalRoll);
        }
    }

    public static int rollD6() {
        return (int) (Math.random() * (6 - 1) + 1);
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
