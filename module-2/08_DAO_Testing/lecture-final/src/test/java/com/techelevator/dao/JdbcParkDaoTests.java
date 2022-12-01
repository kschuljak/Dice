package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests
{

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private Park testPark;

    private JdbcParkDao parkDao;

    @Before
    public void setup()
    {
        parkDao = new JdbcParkDao(dataSource);
        testPark  = new Park(0,"Fun Dome", LocalDate.parse("2005-02-15"), 3, false);
    }

    @Test
    public void getPark_returns_correct_park_for_id()
    {
        // arrange
        int parkId = PARK_2.getParkId();

        // act
        Park actual = parkDao.getPark(parkId);

        // assert
        String message = "Because I searched for parkId: 2";
        assertParksMatch(message, PARK_2, actual);
    }

    @Test
    public void getPark_returns_null_when_id_not_found()
    {
        // arrange
        int parkId = 15;

        // act
        Park actual = parkDao.getPark(parkId);

        // assert
        String message = "Because park 15 does not exist in the database";
        assertNull(message, actual);

    }

    @Test
    public void getParksByState_returns_all_parks_for_state()
    {
        // arrange
        String state = "AA";
        List<Park> expectedParks = List.of(PARK_1, PARK_3);


        // act
        List<Park> actualParks = parkDao.getParksByState(state);

        // assert
        String message = "Because state 'AA' has 2 parks in the database.";
        assertEquals(message, expectedParks.size(), actualParks.size());
        for (int i = 0; i < expectedParks.size(); i++)
        {
            message = "Parks should match at index: " + i;
            assertParksMatch(message, expectedParks.get(i), actualParks.get(i));
        }
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db()
    {
        // arrange
        String state = "ZZ";

        // act
        List<Park> actualParks = parkDao.getParksByState(state);

        // assert
        String message = "Because state 'ZZ' does not exist, and has no parks.";
        assertEquals(message, 0, actualParks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values()
    {
        // arrange - done in the @Before
        // act
        Park actual = parkDao.createPark(testPark);

        // assert
        assertNotNull("Adding a park should return the new park", actual);
        testPark.setParkId(actual.getParkId());
        assertParksMatch("The new park information should match the one that was added", testPark, actual);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved()
    {
        // arrange - done in the @Before
        // act
        Park created = parkDao.createPark(testPark);

        // assert
        Park actual = parkDao.getPark(created.getParkId());
        assertNotNull("The added park was not found in the database.", actual);
        assertParksMatch("The new park information should match the one that was added", created, actual);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved()
    {
        // arrange
        int parkId = 1;
        Park expected = parkDao.getPark(parkId);

        expected.setParkName("Updated Park Name");
        expected.setDateEstablished(LocalDate.parse("2022-12-01"));
        expected.setArea(123);
        expected.setHasCamping(true);

        // act
        parkDao.updatePark(expected);

        // assert
        Park actual = parkDao.getPark(parkId);
        assertParksMatch("The updated park information should have been saved to the database.", expected, actual);
    }

    @Test
    public void deleted_park_cant_be_retrieved()
    {
        // arrange
        int parkId = 1;
        String state = "AA";

        // act
        parkDao.deletePark(parkId);

        // assert
        Park actual = parkDao.getPark(parkId);
        String message = "Because the park should have been deleted from the database.";
        assertNull(message, actual);

        List<Park> actualParks = parkDao.getParksByState(state);
        message = "Park 1 should have been deleted from the database and therefore also from the list of parks for state 'AA'";
        assertEquals(message, 1, actualParks.size());
        assertParksMatch("The remaining park in state AA should be Park 3", PARK_3, actualParks.get(0));

    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state()
    {
        // arrange
        int parkId = PARK_1.getParkId();
        String state = "BB";
        List<Park> expectedParks = List.of(PARK_1, PARK_2);


        // act
        parkDao.addParkToState(parkId, state);

        // assert
        List<Park> actualParks = parkDao.getParksByState(state);
        String message = "Because I added another park to the state.";
        assertEquals(message, expectedParks.size(), actualParks.size());
        for (int i = 0; i < expectedParks.size(); i++)
        {
            message = "Parks should match at index: " + i;
            assertParksMatch(message, expectedParks.get(i), actualParks.get(i));
        }

    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state()
    {
        // arrange
        int parkId = 1;
        String state = "AA";

        // act
        parkDao.removeParkFromState(parkId, state);

        // assert
        List<Park> actualParks = parkDao.getParksByState(state);
        String message = "Park 1 should have been removed from the list of parks for state 'AA'";
        assertEquals(message, 1, actualParks.size());
        assertParksMatch("The remaining park in state AA should be Park 3", PARK_3, actualParks.get(0));
    }

    private void assertParksMatch(String message, Park expected, Park actual)
    {
        Assert.assertEquals(message, expected.getParkId(), actual.getParkId());
        Assert.assertEquals(message, expected.getParkName(), actual.getParkName());
        Assert.assertEquals(message, expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(message, expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(message, expected.getHasCamping(), actual.getHasCamping());
    }

}
