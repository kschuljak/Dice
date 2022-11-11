package com.techelevator.models.pizzas;

import java.math.BigDecimal;

public class Large extends Pizza
{
    public Large()
    {
        super("Large", new BigDecimal("12.99"), new BigDecimal("2"));
    }
}
