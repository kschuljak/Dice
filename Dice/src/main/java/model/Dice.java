package model;

import view.UserOutput;

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
        if (!isValid) UserOutput.printDiceTypeError(dice);
        return isValid;
    }

    public static boolean validateIncrement(int type, int i)
    {
        int minimumIncrement = 1;
        int maximumIncrement = 20;

        boolean isValid = (i >= minimumIncrement && i <= maximumIncrement);

        if (i < minimumIncrement && type == COIN) UserOutput.printNegativeFlipError();
        if (i < minimumIncrement && type != COIN) UserOutput.printNegativeRollError();

        if (i > maximumIncrement && type == COIN) UserOutput.printFlipTimesError();
        if (i > maximumIncrement && type != COIN) UserOutput.printRollTimesError();

        return isValid;
    }

    public static void rollOne(int dice)
    {
        UserOutput.printStartBreak();
        UserOutput.printRollingDiceIntro(dice);
        UserOutput.printRoll(getRoll(dice));
        UserOutput.printEndBreak();
    }

    public static void rollMany(int dice, int increment)
    {
        boolean isValid = validateIncrement(dice, increment);
        if (isValid) {
            UserOutput.printStartBreak();
            UserOutput.printRollingDiceIntro(dice);
            int total = 0;
            for (int i = 1; i <= increment; i++) {
                int roll = getRoll(dice);
                UserOutput.printRoll(roll, i);
                total += roll;
            }
            UserOutput.printRollTotal(total);
            UserOutput.printEndBreak();
        }
    }

    public static void flipOne()
    {
        UserOutput.printStartBreak();
        UserOutput.printFlippingCoinIntro();
        UserOutput.printFlip(flipCoin());
        UserOutput.printEndBreak();
    }

    public static void flipMany(int increment)
    {
        boolean isValid = validateIncrement(COIN, increment);
        if (isValid) {
            UserOutput.printStartBreak();
            UserOutput.printFlippingCoinIntro();
            int headsTotal = 0;
            int tailsTotal = 0;
            for (int i = 1; i <= increment; i++) {
                String flip = flipCoin();
                UserOutput.printFlip(flip, i);
                if (flip.equals("Heads")) headsTotal++;
                if (flip.equals("Tails")) tailsTotal++;
            }
            UserOutput.printFlipTotals(headsTotal, tailsTotal);
            UserOutput.printEndBreak();
        }
    }

}
