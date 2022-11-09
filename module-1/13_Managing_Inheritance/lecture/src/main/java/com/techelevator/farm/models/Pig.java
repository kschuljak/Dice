package com.techelevator.farm.models;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable
{
    public Pig()
    {
        super("Pig", "oink!");
    }

    /*
    FarmAnimal.getSound() marked final - cannot be overridden

    @Override
    public String getSound(){
        return "SCHLOP!";
    }
     */

    @Override
    public BigDecimal getPrice()
    {
        return BigDecimal.valueOf(15);
    }

    public void eat(){
        System.out.println("schloping for food");
    }
}
