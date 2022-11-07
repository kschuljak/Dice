package Dice;

public class D10 extends Dice {

    public D10() {
        super(10);
    }

    public int rollD10() {
        return rollDice(D10);
    }
    public int rollXD10 (int x){
        return rollDiceXTimes(x, D10);
    }

}
