import Dice.Dice;
import java.util.Scanner;

public class DiceRollProgram {

    public void run() {

        Scanner input = new Scanner(System.in);

        printHeader();

        while (true) {
            System.out.println("What would you like to do next? ");
            System.out.println("1) Roll dice");
            System.out.println("2) Exit ");
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(input.nextLine().strip());

            if (choice == 1) {

                printDiceSelectionIntro();
                int diceSelection = Integer.parseInt(input.nextLine().strip());

                printMultipleDiceSelectionIntro();
                int isMultiple = Integer.parseInt(input.nextLine().strip());

                int numberOfTimesToRollDice = 1;
                if (isMultiple == 2) {
                    printHowManyTimesToRollSelectionIntro();
                    numberOfTimesToRollDice = Integer.parseInt(input.nextLine().strip());
                }

                returnDiceRoll(diceSelection, numberOfTimesToRollDice);

            } else break;

        }

    }

    private static void printHeader() {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("************  ROLL DICE  ************");
        System.out.println("*************************************");
        System.out.println();
    }

    private static void printDiceSelectionIntro() {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("What type of dice do you want to roll?");
        System.out.println("(D4 - D6 - D8 - D10 - D12 - D20 - D100)");
        System.out.println("To roll a D4 enter '4', to roll a D6 enter '6', etc.");
        System.out.println();
        System.out.print("Enter option: ");
    }

    private static void printMultipleDiceSelectionIntro() {
        System.out.println();
        System.out.println("Would you like to roll multiple dice? ");
        System.out.println("1) No");
        System.out.println("2) Yes");
        System.out.println();
        System.out.print("Enter option: ");
    }

    private static void printHowManyTimesToRollSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to roll the dice? ");
        System.out.println("Enter a number between 1 & 20: ");
    }

    private void returnDiceRoll(int diceSelection, int numberOfTimesToRollDice){
        System.out.println();
        System.out.println("-------------------------------------");
        Dice.rollDiceXTimesAndPrint(diceSelection, numberOfTimesToRollDice);
        System.out.println("-------------------------------------");
        System.out.println();
    }

}
