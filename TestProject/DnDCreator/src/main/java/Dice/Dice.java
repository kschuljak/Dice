package Dice;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    protected final int COIN = 2;
    protected final int D4 = 4;
    protected final int D6 = 6;
    protected final int D8 = 8;
    protected final int D10 = 10;
    protected final int D12 = 12;
    protected final int D20 = 20;
    protected final int D100 = 100;
    protected int maximumRoll;

    // get random number between min and max (inclusive)
    public static int rollDice(int diceType) {
        return (int) (Math.random() * (diceType - 1) + 1);
    }

    // how many times to roll (for dice type)
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
