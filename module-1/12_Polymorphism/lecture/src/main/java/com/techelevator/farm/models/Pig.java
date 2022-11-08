package com.techelevator.farm.models;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable {

    public Pig() {

        // must meet requirements of superclass to make a subclass from it
        super("Pig", "oink!");
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(15);
    }
}
