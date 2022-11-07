package Dice;

import java.util.ArrayList;
import java.util.List;

public class Coin extends Dice {

    public Coin() {
        super(2);
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
