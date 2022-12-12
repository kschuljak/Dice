package controller;

import java.util.Scanner;
import model.Dice;
import view.UserInput;
import view.UserOutput;

public class DiceApp {

    public void run() {

        UserOutput.printHeader();

        while (true) {
            UserOutput.printDoNext();

            int choice = Integer.parseInt(UserInput.getInput());

            // TO DO: make custom exceptions for error handling
            try {
                if (choice == 1)
                {
                    UserOutput.printDiceSelectionIntro();
                    int diceSelection = Integer.parseInt(UserInput.getInput());

                    UserOutput.printHowManyTimesToRollSelectionIntro();
                    int numberOfTimesToRollDice = Integer.parseInt(UserInput.getInput());

                    if (numberOfTimesToRollDice == 1) Dice.rollOne(diceSelection);
                    if (numberOfTimesToRollDice > 1) Dice.rollMany(diceSelection, numberOfTimesToRollDice);
                }
                else if (choice == 2)
                {
                    UserOutput.printHowManyTimesToFlipSelectionIntro();
                    int coinFlips = Integer.parseInt(UserInput.getInput());

                    if (coinFlips == 1) Dice.flipOne();
                    if (coinFlips > 1) Dice.flipMany(coinFlips);
                }
                else if (choice == 3) break;

                else throw new RuntimeException("You have not made a valid choice.");

            } catch (Exception ex) {
                UserOutput.printException(ex.getMessage());
            }
        }
    }



}
