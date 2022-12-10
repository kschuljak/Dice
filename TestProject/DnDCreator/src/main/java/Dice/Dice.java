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

    // get random number between min and max (inclusive)
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

}
