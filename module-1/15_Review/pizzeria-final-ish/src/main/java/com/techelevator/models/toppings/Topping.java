package com.techelevator.models.toppings;

import java.math.BigDecimal;

public abstract class Topping {

    private String name;
    private BigDecimal price;

    public Topping(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
