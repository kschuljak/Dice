package com.techelevator.farm.models;

public abstract class FarmAnimal implements FarmableAnimal, Singable
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

    public final String getSound()
    {
        return sound;
    }

    public abstract void eat();

}
