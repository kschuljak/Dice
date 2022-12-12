package view;

import view.FontColor;

public class UserOutput {

    public static void printDoNext() {
        System.out.println("What would you like to do next? ");
        System.out.println(FontColor.PURPLE + "1) Roll dice");
        System.out.println("2) Flip coin");
        System.out.println("3) Exit " + FontColor.RESET);
        System.out.println();
        System.out.print("Select an option: ");
    }

    public static void printHeader() {
        System.out.println();
        System.out.println(FontColor.PURPLE + "*************************************************");
        System.out.println("******************  " + FontColor.RESET + "ROLL DICE" + FontColor.PURPLE + "  ******************");
        System.out.println("*************************************************" + FontColor.RESET);
        System.out.println();
    }

    public static void printDiceSelectionIntro() {
        System.out.println();
        printBreak();
        System.out.println("What type of dice do you want to roll?");
        System.out.println(FontColor.PURPLE + "(D4 - D6 - D8 - D10 - D12 - D20 - D100)");
        System.out.println("To roll a D4 enter '4', D6 is '6', etc." + FontColor.RESET);
        System.out.println();
        System.out.print("Enter option: ");
    }

    public static void printHowManyTimesToRollSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to roll the dice? ");
        System.out.print(FontColor.PURPLE + "Enter a number between 1 & 20: " + FontColor.RESET);
    }

    public static void printHowManyTimesToFlipSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to flip the coin? ");
        System.out.print(FontColor.PURPLE + "Enter a number between 1 & 20: " + FontColor.RESET);
    }

    public static void printFlippingCoinIntro() {
        printBreak();
        System.out.println(FontColor.PURPLE + "(Flipping Coin)" + FontColor.RESET);
    }

    public static void printRollingDiceIntro(int diceType) {
        printBreak();
        System.out.println(FontColor.PURPLE + "(Rolling D" + diceType + ")" + FontColor.RESET);
    }

    public static void printRoll(int roll) {
        System.out.println(roll);
        printBreak();
    }

    public static void printRoll(int roll, int i) {
        String increment = String.format("%2s", String.valueOf(i));
        String formattedRoll = String.format("%3s", String.valueOf(roll));
        if (i%2!=0) System.out.println(FontColor.PURPLE + "Roll " + increment + ":   " + FontColor.RESET + formattedRoll);
        else System.out.println(FontColor.PURPLE + "Roll " + increment + ":   " + FontColor.WHITE + formattedRoll + FontColor.RESET);
    }

    public static void printRollTotal(int total) {
        printBreak();
        System.out.println("Roll Total: " + total);
        printBreak();
    }

    public static void printFlip(String flip) {
        System.out.println(flip);
        printBreak();
    }

    public static void printFlip(String flip, int i) {
        String increment = String.format("%2s", i);
        if (flip.equals("Heads")) {
            System.out.println(FontColor.PURPLE + "Flip " + increment + ":   " + FontColor.RESET + flip);
        } else {
            System.out.println(FontColor.PURPLE + "Flip " + increment + ":   " + FontColor.WHITE + flip + FontColor.RESET);
        }

    }

    public static void printFlipTotals(int headsTotal, int tailsTotal) {
        printBreak();
        System.out.println("Total Heads: " + headsTotal);
        System.out.println("Total Tails: " + tailsTotal);
        printBreak();
    }

    public static void printStartBreak() {
        System.out.println();
        printBreak();
    }

    public static void printEndBreak() {
        printBreak();
        System.out.println();
    }

    public static void printBreak() {
        System.out.println(FontColor.PURPLE + "-------------------------------------------------" + FontColor.RESET);
    }

    public static void printDiceTypeError(int diceType) {
        System.out.println(FontColor.RED + "D" + diceType + " is not a valid selection" + FontColor.RESET);
    }

    public static void printRollTimesError() {
        System.out.println(FontColor.RED + "Exceeds maximum allowed dice rolls" + FontColor.RESET);
    }

    public static void printFlipTimesError() {
        System.out.println(FontColor.RED + "Exceeds maximum allowed coin flips" + FontColor.RESET);
    }

    public static void printException(String message) {
        printBreak();
        printBreak();
        System.out.println(message);
        System.out.println("Please try again.");
        printBreak();
        printBreak();
    }

    public static void printColors() {
        System.out.println();
    }
}
