package Backpack;

import Backpack.Coinpurse.Coinpurse;
import Backpack.Gear.Gear;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    protected boolean isTrackingWeight = false;
    protected double totalWeight = 0;
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

    public void equipGear(Gear gear){
        if (!packedGearList.contains(gear)) {
            System.out.println("Error: the requested " + gear.getName() + " is not packed.");
            return;
        }
        packedGearList.remove(gear);
        wornGearList.add(gear);
        System.out.println("The gear has been equipped.");
    }
    public void unEquipGear(Gear gear){
        if (!wornGearList.contains(gear)) {
            System.out.println("Error: the requested " + gear.getName() + " is not equipped.");
        }
        wornGearList.remove(gear);
        packedGearList.add(gear);
        System.out.println("The gear has been packed.");
    }


}
