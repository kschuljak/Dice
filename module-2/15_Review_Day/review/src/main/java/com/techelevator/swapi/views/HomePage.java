package com.techelevator.swapi.views;

public class HomePage extends ViewBase{

    @Override
    public void display() {

        System.out.println();
        System.out.println("******* STAR WARS *******");
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("1) Display CHARACTERS");
        System.out.println("2) Display PLANETS");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println();

        int choice = getValue("Select an option: ");
        setValue(choice);
    }
}
