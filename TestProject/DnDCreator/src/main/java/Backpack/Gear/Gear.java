package Backpack.Gear;

import Backpack.Coinpurse.Coinpurse;
import Backpack.Shop.Shoppable;

public class Gear implements Shoppable {

    final int COPPER = 1;
    final int SILVER = 10;
    final int ELECTRUM = 50;
    final int GOLD = 100;
    final int PLATINUM = 1000;

    protected String name;
    protected String cost = "";
    protected double weightInPounds;

    public Gear(String name, double weightInPounds) {
        this.name = name;
        this.weightInPounds = weightInPounds;
    }

    public Gear(String name, String cost, double weightInPounds) {
        this.name = name;
        this.cost = cost;
        this.weightInPounds = weightInPounds;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }


    public int getCostInCopper(Shoppable item) {
        String[] costValues = cost.split(" ");
        return Integer.parseInt(costValues[0]) * Integer.parseInt(costValues[1]);
    }

    @Override
    public void buy(Shoppable item, Coinpurse coinpurse) {
        int itemCost = getCostInCopper(item);
        coinpurse.spendMoney(itemCost);
    }

    @Override
    public void sell(Shoppable item, Coinpurse coinpurse) {
        int itemCost = getCostInCopper(item);
        coinpurse.earnMoney(itemCost);
    }
}
