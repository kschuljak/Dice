package Backpack.Gear.Weapons;

import Backpack.Gear.*;

import java.util.ArrayList;
import java.util.List;

public class Weapons{

    protected String name;
    protected String cost = "";
    protected int costInCopper;
    protected String damage = "";
    protected double weightInPounds;
    protected List<String> properties = new ArrayList<>();
    protected String type = "";

    public Weapons(String name, String cost, String damage, double weightInPounds, String type){
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.weightInPounds = weightInPounds;
        this.type = type;
    }

}
