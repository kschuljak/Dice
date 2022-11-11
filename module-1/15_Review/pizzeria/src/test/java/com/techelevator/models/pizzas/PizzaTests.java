package com.techelevator.models.pizzas;

import com.techelevator.models.toppings.Ham;
import com.techelevator.models.toppings.Mushroom;
import com.techelevator.models.toppings.Pineapple;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaTests {

    Pizza small = new Small();
    Pizza medium = new Medium();
    Pizza large = new Large();

    @Before
    public void setup(){
        small = new Small();
        medium = new Medium();
        large = new Large();
    }

    @Test
    public void getPrice_ShouldReturn_CorrectPrice_ForSmallPizza(){

        //arrange
        BigDecimal expected = new BigDecimal("7.99");

        //act
        BigDecimal actual = small.getBasePrice();

        //assert
        assertEquals("because a small pizza is 7.99", expected, actual);
    }

    @Test
    public void getPrice_ShouldReturn_CorrectPrice_ForMediumPizza(){

        //arrange
        BigDecimal expected = new BigDecimal("9.99");

        //act
        BigDecimal actual = medium.getBasePrice();

        //assert
        assertEquals("because a medium pizza is 9.99", expected, actual);
    }

    @Test
    public void getPrice_ShouldReturn_CorrectPrice_ForLargePizza(){

        //arrange
        BigDecimal expected = new BigDecimal("12.99");

        //act
        BigDecimal actual = large.getBasePrice();

        //assert
        assertEquals("because a large pizza is 12.99", expected, actual);
    }

    @Test
    public void addTopping_Should_IncreaseToppingCount(){

        //arrange
        int smallExpected = 1;
        int mediumExpected = 1;
        int largeExpected = 1;

        //act
        small.addTopping(new Ham());
        medium.addTopping(new Ham());
        large.addTopping(new Ham());

        //assert
        int actualSmall = small.getNumberOfToppings();
        int actualMedium = medium.getNumberOfToppings();
        int actualLarge = large.getNumberOfToppings();

        assertEquals("because one topping was added to small pizza", smallExpected, actualSmall);
        assertEquals("because one topping was added to medium pizza", mediumExpected, actualMedium);
        assertEquals("because one topping was added to large pizza", largeExpected, actualLarge);
    }

    @Test
    public void getTotalPrice_Should_EqualBasePrice_WithoutToppings(){

        //arrange
        BigDecimal expectedSmall = new BigDecimal("7.99");
        BigDecimal expectedMedium = new BigDecimal("9.99");
        BigDecimal expectedLarge = new BigDecimal("12.99");


        //act
        BigDecimal actualSmall = small.getTotalPrice();
        BigDecimal actualMedium = medium.getTotalPrice();
        BigDecimal actualLarge = large.getTotalPrice();

        //assert
        assertEquals("because a small pizza is 7.99", expectedSmall, actualSmall);
        assertEquals("because a large pizza is 9.99", expectedMedium, actualMedium);
        assertEquals("because a large pizza is 12.99", expectedLarge, actualLarge);
    }

    @Test
    public void getTotalPrice_Should_IncreaseBasePrice_WithAddedToppings(){

        //arrange
        small.addTopping(new Ham());
        small.addTopping(new Pineapple());
        small.addTopping(new Mushroom());
        BigDecimal expectedSmall = new BigDecimal("12.99");

        //act
        BigDecimal actualSmall = small.getTotalPrice();

        //assert
        assertEquals("because small pizza (7.99) + pineapple (2.00) + mushroom (1.00) + ham (2.00)", expectedSmall, actualSmall);

    }


}
