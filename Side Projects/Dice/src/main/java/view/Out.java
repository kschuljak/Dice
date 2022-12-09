package view;

public class Out {

    public static void printDoNext() {
        System.out.println("What would you like to do next? ");
        System.out.println("1) Roll dice");
        System.out.println("2) Flip coin");
        System.out.println("3) Exit ");
        System.out.println();
        System.out.print("Select an option: ");
    }

    public static void printHeader() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("******************  ROLL DICE  ******************");
        System.out.println("*************************************************");
        System.out.println();
    }

    public static void printDiceSelectionIntro() {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("What type of dice do you want to roll?");
        System.out.println("(D4 - D6 - D8 - D10 - D12 - D20 - D100)");
        System.out.println("To roll a D4 enter '4', to roll a D6 enter '6', etc.");
        System.out.println();
        System.out.print("Enter option: ");
    }

    public static void printHowManyTimesToRollSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to roll the dice? ");
        System.out.print("Enter a number between 1 & 20: ");
    }

    public static void printHowManyTimesToFlipCoinSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to flip the coin? ");
        System.out.print("Enter a number between 1 & 20: ");
    }

    public static void printFlippingCoinIntro() {
        System.out.println("-------------------------------------------------");
        System.out.println("(Flipping Coin)");
    }

    public static void printRollingDiceIntro(int diceType) {
        System.out.println("-------------------------------------------------");
        System.out.println("(Rolling D" + diceType + ")");
    }

    public static void printRoll(int roll) {
        System.out.println(roll);
        System.out.println("-------------------------------------------------");
    }

    public static void printRoll(int roll, int i) {
        String increment = String.format("%2s", String.valueOf(i));
        String formattedRoll = String.format("%3s", String.valueOf(roll));
        System.out.println("Roll " + increment + ":   " + formattedRoll);
    }

    public static void printRollTotal(int total) {
        System.out.println("-------------------------------------------------");
        System.out.println("Roll Total: " + total);
        System.out.println("-------------------------------------------------");
    }

    public static void printFlip(String flip) {
        System.out.println(flip);
        System.out.println("-------------------------------------------------");
    }

    public static void printFlip(String flip, int i) {
        String increment = String.format("%2s", String.valueOf(i));
        System.out.println("Flip " + increment + ":   " + flip);
    }

    public static void printFlipTotals(int headsTotal, int tailsTotal) {
        System.out.println("-------------------------------------------------");
        System.out.println("Total Heads: " + headsTotal);
        System.out.println("Total Tails: " + tailsTotal);
        System.out.println("-------------------------------------------------");
    }

    public static void printStartBreak() {
        System.out.println();
        System.out.println("-------------------------------------------------");
    }

    public static void printEndBreak() {
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public static void printBreak() {
        System.out.println("-------------------------------------------------");
    }

    public static void printDiceTypeError(int diceType) {
        System.out.println("D" + diceType + " is not a valid selection");
    }

    public static void printRollTimesError() {
        System.out.println("Exceeds maximum allowed dice rolls");
    }

    public static void printFlipTimesError() {
        System.out.println("Exceeds maximum allowed coin flips");
    }

    public static void printException(String message) {
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        System.out.println(message);
        System.out.println("Please try again.");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
    }
}
