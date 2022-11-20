package Backpack;

import Backpack.Coinpurse.Coinpurse;
import Backpack.Gear.Gear;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    protected boolean isTrackingWeight = false;
    protected double totalWeight = 0;
    protected double maxWeight = 0;
    protected Coinpurse coinpurse;
    protected List<String> trinkets = new ArrayList<>();
    protected List<Gear> wornGearList = new ArrayList<Gear>();
    protected List<Gear> packedGearList = new ArrayList<Gear>();

    public Backpack() {
        coinpurse = new Coinpurse();
    }

    public Backpack(boolean isTrackingWeight) {
        this.isTrackingWeight = isTrackingWeight;
        coinpurse = new Coinpurse();
    }

    public boolean isTrackingWeight() {
        return isTrackingWeight;
    }
    public void setTrackingWeight(boolean trackingWeight) {
        isTrackingWeight = trackingWeight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void addGearToBackpack(Gear gear){
        double gearWeight = gear.getWeightInPounds();
        totalWeight += gearWeight;
        if (isTrackingWeight){
            if (totalWeight > maxWeight) {
                System.out.println("You are over-encumbered!");
                int weightOver = (int)(totalWeight - maxWeight);
                System.out.println("Exceeds max weight by " + weightOver + " pounds.");
            }
        } else packedGearList.add(gear);
    }

    public void removeGearFromBackpack(Gear gear){
        if (!packedGearList.contains(gear) && !wornGearList.contains(gear)){
            System.out.println("Error: the requested " + gear.getName() + " is not packed or equipped.");
        } else if (packedGearList.contains(gear)) packedGearList.remove(gear);
        else if (wornGearList.contains(gear)) wornGearList.remove(gear);
        totalWeight -= gear.getWeightInPounds();
        if (totalWeight < 0) totalWeight = 0;
    }

    public void equipGear(Gear gear){
        if (!packedGearList.contains(gear)) {
            System.out.println("Error: the requested " + gear.getName() + " is not packed.");
            return;
        }
        packedGearList.remove(gear);
        wornGearList.add(gear);
        System.out.println("The gear has been equipped.");
    }
    public void packGear(Gear gear){
        if (!wornGearList.contains(gear)) {
            System.out.println("Error: the requested " + gear.getName() + " is not equipped.");
        }
        wornGearList.remove(gear);
        packedGearList.add(gear);
        System.out.println("The gear has been packed.");
    }


}
