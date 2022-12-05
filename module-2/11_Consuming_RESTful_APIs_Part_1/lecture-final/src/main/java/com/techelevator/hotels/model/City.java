package com.techelevator.hotels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("geoname_id")
    private int geonameId;

    private long population;

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGeonameId(int geonameId){
        this.geonameId = geonameId;
    }

    public String getFullName(){
        return fullName;
    }

    @Override
    public String toString(){
        return fullName + ": " + population;
    }

}
