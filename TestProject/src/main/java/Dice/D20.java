package Dice;

public class D20 extends Dice {

    public D20() {
        super(20);
    }

    public int rollD20() {
        return rollDice(D20);
    }
    public int rollXD20 (int x){
        return rollDiceXTimes(x, D20);
    }

}
