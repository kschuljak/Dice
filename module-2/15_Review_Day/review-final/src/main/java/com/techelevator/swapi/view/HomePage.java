package com.techelevator.swapi.view;

public class HomePage extends ViewBase<Integer>
{
    @Override
    public void display()
    {
        displayHeader("Star Wars");

        System.out.println("What do you want to do?");
        System.out.println("1) Display Characters");
        System.out.println("2) Display Planets");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println();
        int choice = getIntValue("Select an option:");

        setValue(choice);
    }
}
