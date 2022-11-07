package Dice;

public class D8 extends Dice {

    public D8() {
        super(8);
    }

    public int rollD8() {
        return rollDice(D8);
    }
    public int rollXD8 (int x){
        return rollDiceXTimes(x, D8);
    }

}
