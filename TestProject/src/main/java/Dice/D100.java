package Dice;

public class D100 extends Dice {

    public D100() {
        super(100);
    }

    public int rollD100() {
        return rollDice(D100);
    }
    public int rollXD100 (int x){
        return rollDiceXTimes(x, D100);
    }

}
