package com.techelevator.farm.animals;

import com.techelevator.farm.interfaces.Sellable;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable
{
	private BigDecimal price;

    public Cow()
    {
        super("Cow", "moo!");
		this.price = new BigDecimal("1500");
    }

    @Override
    public BigDecimal getPrice()
    {
        return this.price;
    }
}
