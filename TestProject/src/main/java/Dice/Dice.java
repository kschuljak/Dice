package Dice;

public class Dice {

    protected int maximumRoll;

    protected final int COIN = 2;
    protected final int D4 = 4;
    protected final int D6 = 6;
    protected final int D8 = 8;
    protected final int D10 = 10;
    protected final int D12 = 12;
    protected final int D20 = 20;
    protected final int D100 = 100;

    // get random number between min and max (inclusive)
    public static int rollDice(int maximumRoll){
        return (int)(Math.random() * (maximumRoll - 1) + 1);
    }

    // how many times to roll (for dice type)
    public static int rollDiceXTimes(int rollTimes, int maximumRoll) {
        int total = 0;
        for (int i = rollTimes; i > 0; i--) {
            total += rollDice(maximumRoll);
        }
        return total;
    }

    // constructor
    public Dice(int maximumRoll) {
        this.maximumRoll = maximumRoll;
    }
}
