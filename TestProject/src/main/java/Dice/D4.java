package Dice;

public class D4 extends Dice {

    public D4() {
        super(4);
    }

    public int rollD4() {
        return rollDice(D4);
    }
    public int rollXD4 (int x){
        return rollDiceXTimes(x, D4);
    }

}
