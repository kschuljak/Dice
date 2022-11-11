package com.techelevator.models.pizzas;

import com.techelevator.models.toppings.Topping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// a pizza has
//  - 0 or more toppings
//  - base price
//  - total price (total is the base price + price of all toppings)
public abstract class Pizza
{
    private List<Topping> toppings;
    private BigDecimal basePrice;
    private String size;

    private BigDecimal toppingMultiplier;

    public Pizza(String size, BigDecimal basePrice, BigDecimal toppingMultiplier)
    {
        this.basePrice = basePrice;
        this.size = size;
        this.toppingMultiplier = toppingMultiplier;
        toppings = new ArrayList<>();
    }

    public String getSize()
    {
        return size;
    }

    public int getNumberOfToppings()
    {
        return toppings.size();
    }

    public BigDecimal getBasePrice()
    {
        return basePrice;
    }

    public BigDecimal getTotalPrice()
    {
        BigDecimal total = basePrice;

        for (Topping topping : toppings)
        {
            BigDecimal toppingPrice = topping.getPrice();
            BigDecimal newPrice = toppingPrice.multiply(toppingMultiplier);
            total = total.add(newPrice);
        }

        return total;
    }

    public void addTopping(Topping topping)
    {
        toppings.add(topping);
    }

    @Override
    public String toString()
    {
        String value = getSize() + " $" + getTotalPrice();
        value += "\n--------------------------------------";
        value += "\nToppings: " + getNumberOfToppings();
        for (Topping topping : toppings)
        {
            value += "\n  " + topping.getName();
        }

        return value;
    }
}
