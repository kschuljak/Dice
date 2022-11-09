package com.techelevator.farm.models;

public class Chicken extends FarmAnimal
{

    public Chicken()
    {
        super("Chicken", "cluck!");
    }

    public void layEgg()
    {
        System.out.println("Chicken laid an egg!");
    }

}
