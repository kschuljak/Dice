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

    
    public BigDecimal getPrice()
    {
        return new BigDecimal("1500");
    }

    public void eat()
    {
        isEating = true;
        System.out.println("chewing cud");
    }

}
