package com.techelevator.farm.models;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable
{
    public Pig()
    {
        super("Pig", "oink!");
    }

    @Override
    public BigDecimal getPrice()
    {
        return BigDecimal.valueOf(15);
    }
}
