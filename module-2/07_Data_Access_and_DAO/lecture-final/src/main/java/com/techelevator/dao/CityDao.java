package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

public interface CityDao {

    City getCity(int cityId);

    List<City> getCitiesByState(String stateAbbreviation);

    City createCity(City city);

    void updateCity(City city);

    void deleteCity(int cityId);
}
