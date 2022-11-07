package Dice;

public class D12 extends Dice {

    public D12() {
        super(12);
    }

    public int rollD12() {
        return rollDice(D12);
    }
    public int rollXD12 (int x){
        return rollDiceXTimes(x, D12);
    }

}
