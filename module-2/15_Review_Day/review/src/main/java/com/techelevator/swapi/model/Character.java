package com.techelevator.swapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Character {

    private String name;
    private String url;
    private String homeworld;
    @JsonAlias("hair_color")
    private String hairColor;
    @JsonAlias("eye_color")
    private String eyeColor;
    @JsonAlias("birth_year")
    private String birthYear;
}
