package com.techelevator.models.pizzas;

import java.math.BigDecimal;

public class Medium extends Pizza
{
    public Medium()
    {
        super("Medium", new BigDecimal("9.99"), new BigDecimal("1.5"));
    }
}
