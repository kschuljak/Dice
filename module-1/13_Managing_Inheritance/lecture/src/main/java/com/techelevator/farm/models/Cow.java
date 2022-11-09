package com.techelevator.farm.models;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable
{
    boolean isEating = false;

    public Cow(boolean isEating)
    {
        super("Cow", "moo!");
        this.isEating = isEating;
    }

    /*
    FarmAnimal.getSound() marked final - cannot be overridden

    @Override
    public String getSound() {
        if(isEating) return "mmm";
        return super.getSound();
    }
     */
    public BigDecimal getPrice() {
        return new BigDecimal("1500");
    }

    public void eat() {
        System.out.println("grazing for food");
    }
}
