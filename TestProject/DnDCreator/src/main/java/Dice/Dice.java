package Dice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class Dice{

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
        return ThreadLocalRandom.current().nextInt(1, diceType + 1);
    }

    public int rollDiceXTimes(int diceType, int rollTimes) {
        int total = 0;
        for (int i = rollTimes; i > 0; i--) {
            total += rollDice(diceType);
        }
        return total;
    }

    public static void rollDiceAndPrint(int diceType) {
        if (diceType == 4 || diceType == 6 || diceType == 8 || diceType == 10 || diceType == 12 || diceType == 20 || diceType == 100) {
            System.out.println("-------------------------------------");
            System.out.println("(Rolling D" + diceType + ")");
            System.out.println(rollDice(diceType));
            System.out.println("-------------------------------------");

        } else {
            System.out.println("Invalid dice selection");
        }
    }

    public static void rollDiceXTimesAndPrint(int diceType, int rollTimes) {
        if (diceType == 4 || diceType == 6 || diceType == 8 || diceType == 10 || diceType == 12 || diceType == 20 || diceType == 100) {
            int total = 0;
            int rollCounter = 0;
            if (rollTimes > 20) {
                System.out.println("Exceeds maximum allowed number of times to roll dice");
                return;
            }
            System.out.println("-------------------------------------");
            System.out.println("(Rolling D" + diceType + ")");
            for (int i = rollTimes; i > 0; i--) {
                rollCounter++;
                int thisRoll = rollDice(diceType);
                total += thisRoll;
                System.out.println("Roll " + rollCounter + ":  " + thisRoll);
            }
            System.out.println("-------------------------------------");
            System.out.println("Roll Total: " + total);
        } else System.out.println("Invalid dice selection");
    }

    public static String flipCoin() {
        int randomNum = Dice.rollDice(2);
        return (randomNum == 1) ? "Heads" : "Tails";
    }

    public static List<String> flipCoinXTimes(int flipTimes) {
        List<String> totalCoinFlipList = new ArrayList<>();
        for (int i = flipTimes; i > 0; i--) {
            String nextCoinFlip = flipCoin();
            totalCoinFlipList.add(nextCoinFlip);
        }
        return totalCoinFlipList;
    }

    public static void flipCoinAndPrint() {
        System.out.println("-------------------------------------");
        System.out.println("(Flipping Coin)");
        System.out.println(flipCoin());
        System.out.println("-------------------------------------");
    }

    public static void flipCoinXTimesAndPrint(int flipTimes) {
        if (flipTimes > 20) {
            System.out.println("Exceeds maximum allowed number of times to flip coin");
            return;
        }
        System.out.println("-------------------------------------");
        System.out.println("(Flipping Coin)");
        List<String> coinFlips = flipCoinXTimes(flipTimes);
        int headsTotal = 0;
        int tailsTotal = 0;
        for (String flip : coinFlips) {
            System.out.println(flip);
            if (flip.equals("Heads")) headsTotal++;
            if (flip.equals("Tails")) tailsTotal++;
        }
        System.out.println("-------------------------------------");
        System.out.println("Total Heads: " + headsTotal);
        System.out.println("Total Tails: " + tailsTotal);
    }

}
