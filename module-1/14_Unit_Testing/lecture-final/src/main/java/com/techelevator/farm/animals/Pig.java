package com.techelevator.farm.animals;

import com.techelevator.farm.interfaces.Sellable;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable
{
    private BigDecimal price;

    public Pig()
    {
        super("Pig", "Oink!");
        this.price = new BigDecimal("300");
    }

    public BigDecimal getPrice()
    {
        return this.price;
    }
}
