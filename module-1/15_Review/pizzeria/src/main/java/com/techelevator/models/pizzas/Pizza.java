package com.techelevator.models.pizzas;

import com.techelevator.models.toppings.Topping;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

// a pizza has
//  - 0 or more toppings
//  - base price
//  - total price (total is the base price + price of all toppings)
public abstract class Pizza
{
    private BigDecimal basePrice;
    private BigDecimal toppingSize;
    private List<Topping> toppingList;
    private String size;

    public Pizza(String size, BigDecimal basePrice, BigDecimal toppingSize) {
        this.size = size;
        this.basePrice = basePrice;
        this.toppingSize = toppingSize;
        toppingList = new ArrayList<>();
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }
    public String getSize() {
        return size;
    }
    public void addTopping(Topping topping){
        toppingList.add(topping);
    }
    public int getNumberOfToppings(){
        return toppingList.size();
    }

    public BigDecimal getTotalPrice(){
        BigDecimal total = basePrice;
        for (Topping topping : toppingList){
            BigDecimal toppingPrice = topping.getPrice().multiply(toppingSize);
            total = total.add(toppingPrice);
        }
        return total;
    }

    @Override
    public String toString(){
        String value = getSize() + " $" + getTotalPrice();
        value += "\n---------------------------------------";
        value += "\nToppings: " + getNumberOfToppings();
        for (Topping topping : toppingList){
            value += "\n " + topping.getName();
        }
        return value;
    }
}
