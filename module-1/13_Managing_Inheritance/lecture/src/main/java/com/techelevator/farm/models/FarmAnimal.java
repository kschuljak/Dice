package com.techelevator.farm.models;

// abstract class very similar to an interface - we don't have enough information to create an instance of it
// you can only inherit from an abstract class
// abstraction - removing everything unnecessary to simplify code
public abstract class FarmAnimal implements Singable
{
    private String name;
    private String sound;

    public FarmAnimal(String name, String sound)
    {
        this.name = name;
        this.sound = sound;
    }

    public String getName()
    {
        return name;
    }

    // final - prevents method from being overwritten by child classes
    public final String getSound()
    {
        return sound;
    }

    public abstract void eat();

}
