package Dice;

public class D6 extends Dice {

    public D6() {
        super(6);
    }

    public int rollD6() {
        return rollDice(D6);
    }
    public int rollXD6 (int x){
        return rollDiceXTimes(x, D6);
    }

}
