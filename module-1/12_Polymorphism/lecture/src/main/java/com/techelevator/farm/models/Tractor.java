package com.techelevator.farm.models;

// have to implement Singable to enter contract
public class Tractor implements Singable{

    public Tractor() {
    }

    // have to implement methods in Singable interface to fulfill contract
    public String getName() {
        return "Big Red";
    }
    public String getSound() {
        return "vroom!";
    }
}
