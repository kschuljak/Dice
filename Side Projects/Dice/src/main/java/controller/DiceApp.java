package controller;

import java.util.Scanner;
import model.Dice;
import view.Out;

public class DiceApp {

    public void run() {

        Scanner input = new Scanner(System.in);

        Out.printHeader();

        while (true) {
            Out.printDoNext();

            int choice = Integer.parseInt(input.nextLine().strip());

            try {
                if (choice == 1)
                {
                    Out.printDiceSelectionIntro();
                    int diceSelection = Integer.parseInt(input.nextLine().strip());

                    Out.printHowManyTimesToRollSelectionIntro();
                    int numberOfTimesToRollDice = Integer.parseInt(input.nextLine().strip());

                    if (numberOfTimesToRollDice == 1) Dice.rollOne(diceSelection);
                    if (numberOfTimesToRollDice > 1) Dice.rollMany(diceSelection, numberOfTimesToRollDice);
                }
                else if (choice == 2)
                {
                    Out.printHowManyTimesToFlipCoinSelectionIntro();
                    int coinFlips = Integer.parseInt(input.nextLine().strip());

                    if (coinFlips == 1) Dice.flipOne();
                    if (coinFlips > 1) Dice.flipMany(coinFlips);
                }
                else if (choice == 3) break;

                else throw new RuntimeException("You have not made a valid choice.");

            } catch (Exception ex) {
                Out.printException(ex.getMessage());
            }
        }
    }



}
