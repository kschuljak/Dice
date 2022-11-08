package com.techelevator.farm;

import com.techelevator.farm.models.Chicken;
import com.techelevator.farm.models.Cow;
import com.techelevator.farm.models.FarmAnimal;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald
{

    private List<FarmAnimal> animals;

    public OldMacdonald()
    {
        animals = new ArrayList<>();
    }

    public void run()
    {
        sayHello();

        singSong();
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

        animals.add(new Cow());
        animals.add(new Chicken());

        for(FarmAnimal animal : animals)
        {
            singVerse(animal);
        }
    }

    public void singVerse(FarmAnimal animal)
    {
        String name = animal.getName();
        String sound = animal.getSound();
        System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
        System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
        System.out.println("With a " + sound + " " + sound + " here");
        System.out.println("And a " + sound + " " + sound + " there");
        System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
        System.out.println();
    }

}
