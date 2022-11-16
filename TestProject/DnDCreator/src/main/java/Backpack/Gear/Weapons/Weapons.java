package Backpack.Gear.Weapons;

import Backpack.Gear.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapons extends Gear{

    protected String damage = "";
    protected List<String> properties = new ArrayList<>();
    protected String type = "";

    public Weapons(String name, String cost, String damage, double weightInPounds, String type){
        super(name, cost, weightInPounds);
        this.damage = damage;
        this.type = type;
    }

}
