package Backpack.Gear.Tools;

import Backpack.Gear.Gear;

public abstract class Tools extends Gear {

    boolean HasProficiency = false;

    public Tools(String name, String cost, double weight){
        super(name, cost, weight);
    }
}
