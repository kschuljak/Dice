package Backpack.Gear;

public class Gear {

    protected String name;
    protected String cost = "";
    protected int costInCopper;
    protected double weightInPounds;

    public Gear(String name, double weightInPounds) {
        this.name = name;
        this.weightInPounds = weightInPounds;
    }
}
