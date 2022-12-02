package com.techelevator.dao;

import com.techelevator.model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JdbcCityDaoTests extends BaseDaoTests
{

    private static final City CITY_1 = new City(1, "City 1", "AA", 11, 111);
    private static final City CITY_2 = new City(2, "City 2", "BB", 22, 222);
    private static final City CITY_4 = new City(4, "City 4", "AA", 44, 444);

    private static final List<City> CITIES = List.of(CITY_1, CITY_2, CITY_4);
    private static final List<City> AA_CITIES = List.of(CITY_1, CITY_4);
    private static final List<City> BB_CITIES = List.of(CITY_2);
    private static final Map<String, List<City>> STATE_CITIES = Map.of(
            "AA", AA_CITIES,
            "BB", BB_CITIES
    );

    private City testCity;

    private JdbcCityDao cityDao;

    @Before
    public void setup()
    {
        cityDao = new JdbcCityDao(dataSource);
        testCity = new City(0, "Test City", "CC", 99, 999);
    }

    @Test
    public void getCity_returns_correct_city_for_id()
    {
        for (City expectedCity : CITIES)
        {
            // arrange
            int cityId = expectedCity.getCityId();

            // act
            City actualCity = cityDao.getCity(cityId);

            // assert
            String message = "Because I searched for city id: " + cityId;
            assertCitiesMatch(message, expectedCity, actualCity);
        }
    }

    @Test
    public void getCity_returns_null_when_id_not_found()
    {
        // arrange
        int cityId = 99;

        // act
        City actual = cityDao.getCity(99);

        // assert
        String message = "Because city id 99 should not find a city in the database.";
        Assert.assertNull(message, actual);
    }

    @Test
    public void getCitiesByState_returns_all_cities_for_state_AA()
    {
        // arrange
        String state = "AA";
        List<City> expectedCities = AA_CITIES;

        // act
        List<City> actualCities = cityDao.getCitiesByState(state);

        // assert
        String message = "Because state " + state + " should have " + expectedCities.size() + " cities";
        Assert.assertEquals(message, expectedCities.size(), actualCities.size());
        for (int i = 0; i < expectedCities.size(); i++)
        {
            message = "Search results state: " + state + "; city: " + i;
            assertCitiesMatch(message, expectedCities.get(i), actualCities.get(i));
        }
    }

    @Test
    public void getCitiesByState_returns_all_cities_for_state_BB()
    {
        // arrange
        String state = "BB";
        List<City> expectedCities = BB_CITIES;

        // act
        List<City> actualCities = cityDao.getCitiesByState(state);
        // assert
        String message = "Because state " + state + " should have " + expectedCities.size() + " cities";
        Assert.assertEquals(message, expectedCities.size(), actualCities.size());
        for (int i = 0; i < expectedCities.size(); i++)
        {
            message = "Search results state: " + state + "; city: " + i;
            assertCitiesMatch(message, expectedCities.get(i), actualCities.get(i));
        }
    }

    @Test
    public void getCitiesByState_returns_empty_list_for_abbreviation_not_in_db()
    {
        // arrange
        String state = "XX";

        // act
        List<City> cities = cityDao.getCitiesByState(state);

        // assert
        String message ="Because I searched for state 'XX'.";
        Assert.assertEquals(message,0, cities.size());
    }

    @Test
    public void createCity_returns_city_with_id_and_expected_values()
    {
        // arrange - in the @Before method
        // act
        City createdCity = cityDao.createCity(testCity);

        // assert
        int newId = createdCity.getCityId();
        String message ="Because a new ID should have been generated and returned from the DAO";
        Assert.assertTrue(message,newId > 0);

        testCity.setCityId(newId);
        message = "Because the object returned from the DAO should have all the values that were provided.";
        assertCitiesMatch(message, testCity, createdCity);
    }

    @Test
    public void created_city_has_expected_values_when_retrieved()
    {
        // arrange - in the @Before method
        //act
        City createdCity = cityDao.createCity(testCity);

        // assert
        int newId = createdCity.getCityId();
        // search for the city in the db
        City retrievedCity = cityDao.getCity(newId);

        String message ="Because the new city that was created should have all values correctly stored in the database.";
        assertCitiesMatch(message, createdCity, retrievedCity);
    }

    @Test
    public void updated_city_has_expected_values_when_retrieved()
    {
        // arrange
        int cityId = 1;
        // get existing city from DB
        City cityToUpdate = cityDao.getCity(cityId);
        // modify values
        cityToUpdate.setCityName("Updated");
        cityToUpdate.setStateAbbreviation("CC");
        cityToUpdate.setPopulation(99);
        cityToUpdate.setArea(999);

        // act
        cityDao.updateCity(cityToUpdate);

        // assert
        // search for updates in database
        City retrievedCity = cityDao.getCity(cityId);
        String message ="Because the city that was updated should have all values correctly saved in the database.";
        assertCitiesMatch(message, cityToUpdate, retrievedCity);
    }

    @Test
    public void deleted_city_cant_be_retrieved()
    {
        // arrange
        int cityId = 4;
        String state = "AA";

        // act
        cityDao.deleteCity(cityId);

        // assert
        // search for the deleted city
        City retrievedCity = cityDao.getCity(cityId);
        String message = "Because the city should no longer exist in the database.";
        Assert.assertNull(message, retrievedCity);

        // ensure that searching for cities by state is also correct
        List<City> cities = cityDao.getCitiesByState(state);
        message = "Because state 'AA' should now only have 1 city in it's list";
        Assert.assertEquals(message,1, cities.size());
        // verify city specifics
        message = "Because the only city in state 'AA' should be 'City 1'.";
        assertCitiesMatch(message, CITY_1, cities.get(0));
    }

    private void assertCitiesMatch(String message, City expected, City actual)
    {
        Assert.assertEquals(message, expected.getCityId(), actual.getCityId());
        Assert.assertEquals(message, expected.getCityName(), actual.getCityName());
        Assert.assertEquals(message, expected.getStateAbbreviation(), actual.getStateAbbreviation());
        Assert.assertEquals(message, expected.getPopulation(), actual.getPopulation());
        Assert.assertEquals(message, expected.getArea(), actual.getArea(), 0.1);
    }
}
