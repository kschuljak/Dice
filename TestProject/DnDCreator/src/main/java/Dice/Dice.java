package Dice;

import java.util.ArrayList;
import java.util.List;

public final class Dice {

    final int COIN = 2;
    final int D4 = 4;
    final int D6 = 6;
    final int D8 = 8;
    final int D10 = 10;
    final int D12 = 12;
    final int D20 = 20;
    final int D100 = 100;

    // get random number between min and max (inclusive) - NO print
    public static int rollDice(int diceType) {
        return (int) (Math.random() * (diceType - 1) + 1);
    }

    // how many times to roll (for dice type) and print
    public static void rollDiceXTimesAndPrint(int diceType, int rollTimes) {
        int total = 0;
        int rollCounter = 0;
        System.out.println("-------------------------------------");
        for (int i = rollTimes; i > 0; i--) {
            rollCounter++;
            int thisRoll = rollDice(diceType);
            total += thisRoll;
            System.out.println("Roll " + rollCounter + ":  " + thisRoll);
        }
        System.out.println("-------------------------------------");
        System.out.println("Roll Total: " + total);
        System.out.println("-------------------------------------");
    }

    // how many times to roll (for dice type) - NO print
    public static int rollDiceXTimes(int diceType, int rollTimes) {
        int total = 0;
        for (int i = rollTimes; i > 0; i--) {
            total += rollDice(diceType);
        }
        return total;
    }

    public String flipCoin() {
        int randomNum1Or2 = Dice.rollDice(COIN);
        return (randomNum1Or2 == 1) ? "heads" : "tails";
    }

    public List<String> flipCoinXTimes(int flipTimes) {
        List<String> totalCoinFlipList = new ArrayList<>();
        for (int i = flipTimes; i > 0; i--) {
            String nextCoinFlip = flipCoin();
            totalCoinFlipList.add(nextCoinFlip);
        }
        return totalCoinFlipList;
    }

}
