package model;

import view.Out;

import java.util.concurrent.ThreadLocalRandom;

public class Dice{

    static final int COIN = 2;
    static final int D4 = 4;
    static final int D6 = 6;
    static final int D8 = 8;
    static final int D10 = 10;
    static final int D12 = 12;
    static final int D20 = 20;
    static final int D100 = 100;

    // get random number between min and max (inclusive)
    public static int getRoll(int diceType)
    {
        return ThreadLocalRandom.current().nextInt(1, diceType + 1);
    }

    public static String flipCoin()
    {
        int randomNum = Dice.getRoll(COIN);
        return (randomNum == 1) ? "Heads" : "Tails";
    }

    public static boolean validateDice(int dice)
    {
        boolean isValid = (dice == D4 || dice == D6 || dice == D8 || dice == D10 || dice == D12 || dice == D20 || dice == D100);
        if (!isValid) Out.printDiceTypeError(dice);
        return isValid;
    }

    public static boolean validateIncrement(int type, int i)
    {
        int minimumIncrement = 1;
        int maximumIncrement = 20;

        boolean isValid = (i >= minimumIncrement && i <= maximumIncrement);
        if (!isValid && type == COIN) Out.printFlipTimesError();
        if (!isValid && type != COIN) Out.printRollTimesError();
        return isValid;
    }

    public static void rollOne(int dice)
    {
        boolean isValid = validateDice(dice);
        Out.printStartBreak();
        if (isValid) {
            Out.printRollingDiceIntro(dice);
            Out.printRoll(getRoll(dice));
        }
        Out.printEndBreak();
    }

    public static void rollMany(int dice, int increment)
    {
        boolean isValid = (validateDice(dice) && validateIncrement(dice, increment));
        if (isValid) {
            Out.printStartBreak();
            Out.printRollingDiceIntro(dice);
            int total = 0;
            for (int i = 1; i <= increment; i++) {
                int roll = getRoll(dice);
                Out.printRoll(roll, i);
                total += roll;
            }
            Out.printRollTotal(total);
            Out.printEndBreak();
        }
    }

    public static void flipOne()
    {
        Out.printStartBreak();
        Out.printFlippingCoinIntro();
        Out.printFlip(flipCoin());
        Out.printEndBreak();
    }

    public static void flipMany(int increment)
    {
        boolean isValid = validateIncrement(COIN, increment);
        if (isValid) {
            Out.printStartBreak();
            Out.printFlippingCoinIntro();
            int headsTotal = 0;
            int tailsTotal = 0;
            for (int i = 1; i <= increment; i++) {
                String flip = flipCoin();
                Out.printFlip(flip, i);
                if (flip.equals("Heads")) headsTotal++;
                if (flip.equals("Tails")) tailsTotal++;
            }
            Out.printFlipTotals(headsTotal, tailsTotal);
            Out.printEndBreak();
        }
    }

}
