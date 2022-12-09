package com.techelevator.swapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Character
{
    private String name;
    private String url;
    private String homeworld;
    @JsonAlias("hair_color")
    private String hairColor;
    @JsonAlias("eye_color")
    private String eyeColor;
    @JsonAlias("birth_year")
    private String birthYear;

    public int getId()
    {
        String[] parts = url.split("/");
        int index = parts.length - 1;

        return Integer.parseInt(parts[index]);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getHomeworld()
    {
        return homeworld;
    }

    public void setHomeworld(String homeworld)
    {
        this.homeworld = homeworld;
    }

    public String getHairColor()
    {
        return hairColor;
    }

    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }

    public String getEyeColor()
    {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear()
    {
        return birthYear;
    }

    public void setBirthYear(String birthYear)
    {
        this.birthYear = birthYear;
    }
}
