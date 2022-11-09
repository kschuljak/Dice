package com.techelevator.farm;

import com.techelevator.farm.models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald
{

    private List<Singable> singableList;
    private List<Sellable> sellableList;

    public OldMacdonald()
    {
        singableList = new ArrayList<>();
        sellableList = new ArrayList<>();

        // add all singables
        singableList.add(new Cow());
        singableList.add(new Chicken());
        singableList.add(new Pig());
        singableList.add(new Tractor());

        // add all sellables
        sellableList.add(new Egg());
        sellableList.add(new Cookie("Chocolate Chip Cookie", BigDecimal.ONE));
        sellableList.add(new Cookie("Sugar Cookie", BigDecimal.ONE));
        sellableList.add(new Pig());
    }

    public void run()
    {
        Scanner input = new Scanner(System.in);

        sayHello();

        while(true)
        {
            System.out.println();
            System.out.println("What do you want to do next? ");
            System.out.println("1) Sing the song");
            System.out.println("2) Go to the market");
            System.out.println("3) Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(input.nextLine());
            System.out.println();
            System.out.println();

            if(choice == 1)
            {
                singSong();
            }
            else if( choice == 2)
            {
                goToMarket();
            }
            else
            {
                break;
            }

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
        System.out.println();
        System.out.println("Okay... Here we go");
        System.out.println();
        System.out.println("Bump dee, Bump dee");
        System.out.println("Bump dee, Bump dee");
        System.out.println();

        for(Singable singable : singableList)
        {
            singVerse(singable);
        }
    }

    public void singVerse(Singable singable)
    {
        String name = singable.getName();
        String sound = singable.getSound();
        System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
        System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
        System.out.println("With a " + sound + " " + sound + " here");
        System.out.println("And a " + sound + " " + sound + " there");
        System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
        System.out.println();
    }

    public void goToMarket()
    {
        System.out.println();
        System.out.println("Hear ye, Hear ye");
        System.out.println("The market is open");
        System.out.println();

        System.out.println("Come and get your food: ");
        for (Sellable sellable : sellableList)
        {
            System.out.println(sellable.getName() + " for $" + sellable.getPrice());
        }
    }

}
