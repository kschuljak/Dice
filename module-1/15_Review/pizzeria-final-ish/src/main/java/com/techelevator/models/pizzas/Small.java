package com.techelevator.models.pizzas;

import java.math.BigDecimal;

public class Small extends Pizza
{
    public Small()
    {
        super("Small", new BigDecimal("7.99"), BigDecimal.ONE);
    }
}
