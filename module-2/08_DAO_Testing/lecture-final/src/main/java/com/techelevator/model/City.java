package com.techelevator.model;

public class City {

    private int cityId;
    private String cityName;
    private String stateAbbreviation;
    private int population;
    private double area;

    public City() {

    }

    public City(int cityId, String cityName, String stateAbbreviation, int population, double area) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.stateAbbreviation = stateAbbreviation;
        this.population = population;
        this.area = area;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getCityName(), getStateAbbreviation(), getCityId());
    }
}
