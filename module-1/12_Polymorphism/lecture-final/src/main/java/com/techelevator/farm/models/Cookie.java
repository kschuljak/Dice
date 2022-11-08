package com.techelevator.farm.models;

import java.math.BigDecimal;

public class Cookie implements Sellable
{
    private String name;
    private BigDecimal price;

    public Cookie(String name, BigDecimal price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public BigDecimal getPrice()
    {
        return price;
    }
}
