package com.techelevator.farm;

import com.techelevator.farm.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald
{
    // List is an interface of List<E>
    private List<Singable> singableItems;

    // if animals not instantiated as an array list, it will be null.
    // null will throw an exception at line 37 (null.add)
    public OldMacdonald() {
        singableItems = new ArrayList<>();

        singableItems.add(new Cow());
        singableItems.add(new Chicken());
        singableItems.add(new Pig());
        singableItems.add(new Tractor());

    }
    public void run()
    {
        Scanner input = new Scanner(System.in);

        sayHello();

        // what do you want to do?
        // 1 - sing a song
        // 2 - go to the market
        // 3 - exit
        // infinite loop until user chooses exit
        while(true){
            System.out.println();
            System.out.println("What do you want to do next? ");
            System.out.println("1) Sing a song");
            System.out.println("2) Go to the market");
            System.out.println("3) Exit");
            System.out.println("Select an option: ");
            // pauses loop to wait for user input
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 1) singSong();
            else if (choice == 2) System.out.println("go to market");
            else break;
        }

    }

    public void sayHello()
    {
        System.out.println();
        System.out.println("Hello Kids!");
        System.out.println("I'm Old MacDonald...");
        System.out.println("Welcome to my farm!");
        System.out.println();
    }

    private void singSong()
    {

        for(Singable item : singableItems)
        {
            singVerse(item);
        }
    }

    public void singVerse(Singable item)
    {
        String name = item.getName();
        String sound = item.getSound();
        System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
        System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
        System.out.println("With a " + sound + " " + sound + " here");
        System.out.println("And a " + sound + " " + sound + " there");
        System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
        System.out.println();
    }

}
