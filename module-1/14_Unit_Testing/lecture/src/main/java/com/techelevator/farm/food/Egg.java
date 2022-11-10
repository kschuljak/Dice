package com.techelevator.farm.food;

import com.techelevator.farm.interfaces.Sellable;

import java.math.BigDecimal;

public class Egg implements Sellable
{
    private String name;
    private BigDecimal price;

    public Egg()
    {
        this.name = "Egg";
        price = new BigDecimal(".25");
    }

    public String getName()
    {
        return this.name;
    }

    public BigDecimal getPrice()
    {
        return this.price;
    }
}
