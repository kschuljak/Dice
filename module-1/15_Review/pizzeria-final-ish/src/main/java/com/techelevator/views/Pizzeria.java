package com.techelevator.views;

import com.techelevator.models.pizzas.Large;
import com.techelevator.models.pizzas.Medium;
import com.techelevator.models.pizzas.Pizza;
import com.techelevator.models.pizzas.Small;
import com.techelevator.models.toppings.Jalapeno;
import com.techelevator.models.toppings.Pineapple;

import java.util.Scanner;

// this is the application
// it does not include the static void main method
//      - that is found in the Program class
public class Pizzeria
{
    Scanner input = new Scanner(System.in);

    public void run()
    {

        System.out.println("Welcome to the pizzeria!");

        Pizza pizza = selectPizzaSize();


        // how would I loop and prompt the user for multiple toppings?
        // what if they don't more?

        pizza.addTopping(new Jalapeno());
        pizza.addTopping(new Pineapple());

//        System.out.println("Enjoy your " + pizza.getSize() + " pizza");
        System.out.println(pizza);



    }

    private Pizza selectPizzaSize()
    {
        System.out.println();
        System.out.println("What size pizza do you want? ");
        System.out.println("S) Small  - $  7.99");
        System.out.println("M) Medium - $  9.99");
        System.out.println("L) Large  - $ 12.99");
        System.out.print("Make a selection: ");

        String selection = input.nextLine().trim();
        return buildPizza(selection);
    }

    private Pizza buildPizza(String size)
    {
        if(size.equalsIgnoreCase("S"))
            return new Small();
        else if(size.equalsIgnoreCase("M"))
            return new Medium();
        else
            return new Large();
    }
}
