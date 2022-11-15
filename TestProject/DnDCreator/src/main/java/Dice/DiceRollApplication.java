package Dice;

import java.util.Scanner;


public class DiceRollApplication {

    public void run() {

        Scanner input = new Scanner(System.in);

        printHeader();

        while (true) {
            System.out.println("What would you like to do next? ");
            System.out.println("1) Roll dice");
            System.out.println("2) Flip coin");
            System.out.println("3) Exit ");
            System.out.println();
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(input.nextLine().strip());

            if (choice == 1) {

                printDiceSelectionIntro();
                int diceSelection = Integer.parseInt(input.nextLine().strip());

                printHowManyTimesToRollSelectionIntro();
                int numberOfTimesToRollDice = Integer.parseInt(input.nextLine().strip());
                if (numberOfTimesToRollDice == 1) returnDiceRollSingle(diceSelection);
                if (numberOfTimesToRollDice > 1) returnDiceRollMultiple(diceSelection, numberOfTimesToRollDice);

            } else if (choice == 2) {

                printHowManyTimesToFlipCoinSelectionIntro();
                int coinFlips = Integer.parseInt(input.nextLine().strip());
                if (coinFlips == 1) returnFlipCoinSingle();
                if (coinFlips > 1) returnFlipCoinMultiple(coinFlips);

            } else break;

        }

    }

    private void printHeader() {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("************  ROLL DICE  ************");
        System.out.println("*************************************");
        System.out.println();
    }

    private void printDiceSelectionIntro() {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("What type of dice do you want to roll?");
        System.out.println("(D4 - D6 - D8 - D10 - D12 - D20 - D100)");
        System.out.println("To roll a D4 enter '4', to roll a D6 enter '6', etc.");
        System.out.println();
        System.out.print("Enter option: ");
    }

    private void printHowManyTimesToRollSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to roll the dice? ");
        System.out.println("Enter a number between 1 & 20: ");
    }

    private void printHowManyTimesToFlipCoinSelectionIntro() {
        System.out.println();
        System.out.println("How many times would you like to flip the coin? ");
        System.out.println("Enter a number between 1 & 20: ");
    }

    public void returnDiceRollSingle(int diceSelection){
        System.out.println();
        System.out.println("-------------------------------------");
        Dice.rollDiceAndPrint(diceSelection);
        System.out.println("-------------------------------------");
        System.out.println();
    }

    public void returnDiceRollMultiple(int diceSelection, int numberOfTimesToRollDice){
        System.out.println();
        System.out.println("-------------------------------------");
        Dice.rollDiceXTimesAndPrint(diceSelection, numberOfTimesToRollDice);
        System.out.println("-------------------------------------");
        System.out.println();
    }

    public void returnFlipCoinSingle() {
        System.out.println();
        System.out.println("-------------------------------------");
        Dice.flipCoinAndPrint();
        System.out.println("-------------------------------------");
        System.out.println();
    }

    public void returnFlipCoinMultiple(int numberOfTimesToFlipCoin) {
        System.out.println();
        System.out.println("-------------------------------------");
        Dice.flipCoinXTimesAndPrint(numberOfTimesToFlipCoin);
        System.out.println("-------------------------------------");
        System.out.println();
    }

}
