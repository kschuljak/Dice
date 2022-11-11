package com.techelevator.models.pizzas;

import com.techelevator.models.toppings.Ham;
import com.techelevator.models.toppings.Pineapple;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaTests
{
    Pizza small;
    Pizza medium;
    Pizza large;

    @Before
    public void setup()
    {
        small = new Small();
        medium = new Medium();
        large = new Large();
    }


    @Test
    public void getBasePrice_ShouldReturn_CorrectPrice_ForSmallPizza()
    {
        // arrange
        BigDecimal expected = new BigDecimal("7.99");

        // act
        BigDecimal actual = small.getBasePrice();

        // assert
        assertEquals("Because a small pizza should be 7.99", expected, actual);
    }

    @Test
    public void addTopping_Should_IncreaseToppingCount()
    {
        // arrange
        int expected = 1;

        // act
        small.addTopping(new Ham());

        // assert
        int actual = small.getNumberOfToppings();
        assertEquals("Because I added ham", expected, actual);
    }

    @Test
    public void getTotalPrice_Should_EqualBasePrice_WithoutToppings()
    {
        // arrange
        BigDecimal expected = small.getBasePrice();

        // act
        BigDecimal actual = small.getTotalPrice();

        // assert
        assertEquals("Because I didn't add any toppings", expected, actual);
    }

    @Test
    public void getTotalPrice_Should_EqualBasePricePlusPriceOfToppings_OnSmallPizza()
    {
        // arrange
        small.addTopping(new Ham());
        small.addTopping(new Pineapple());
        BigDecimal expected = new BigDecimal("10.99");

        // act
        BigDecimal actual = small.getTotalPrice();

        // assert
        assertEquals("Because I added ham and pineapple to a small - add $3", expected, actual);
    }


    @Test
    public void getTotalPrice_Should_EqualBasePricePlusPriceOfToppings_OnLargePizza()
    {
        // arrange
        // toppings on large pizza are double the regular topping cost
        large.addTopping(new Ham());
        large.addTopping(new Pineapple());
        BigDecimal expected = new BigDecimal("18.99");

        // act
        BigDecimal actual = large.getTotalPrice();

        // assert
        assertEquals("Because toppings on a large are twice the price of a small", expected, actual);
    }



}
