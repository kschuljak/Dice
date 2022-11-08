package com.techelevator.farm.models;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Egg implements Sellable{

    private String name;
    private BigDecimal price;

    public Egg() {
        name = "Egg";
        price = new BigDecimal("0.50", new MathContext(2, RoundingMode.HALF_EVEN));
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
