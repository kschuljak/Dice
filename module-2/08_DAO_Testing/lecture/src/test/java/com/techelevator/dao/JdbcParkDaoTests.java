package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    // sut = system under test (changed to parkDao)
    private JdbcParkDao parkDao;

    @Before
    public void setup() {
        parkDao = new JdbcParkDao(dataSource);
    }

    // tests populated with 'Assert.fail();' before being coded
    @Test
    public void getPark_returns_correct_park_for_id() {

        // arrange
        int parkId = PARK_2.getParkId();

        // act
        Park actual = parkDao.getPark(parkId);

        // assert
        String message = "Because I searched for parkId: 2";
        assertParksMatch(message, PARK_2, actual);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Assert.fail();
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        Assert.fail();
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        Assert.fail();
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Assert.fail();
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        Assert.fail();
    }

    // .contains() searching a list of objects checks for REFERENCE
    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {

        // arrange
        // add park to park_state table
        int parkId = PARK_1.getParkId();
        String state = "BB";
        List<Park> expectedParks = List.of(PARK_1, PARK_2);

        // act
        parkDao.addParkToState(parkId, state);

        // assert
        List<Park> actualParks = parkDao.getParksByState(state);
        String message = "Because I added PARK_1 to state BB";
        assertEquals(message, expectedParks.size(), actualParks.size());
        // because getParksByState orders parks by park_id, list order is known
        for (int i = 0; i < expectedParks.size(); i++) {
            message = "Parks should match at index: " + i;
            assertParksMatch(message, expectedParks.get(i), actualParks.get(i));
        }
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {

        // arrange
        // remove park by park_id from park_state table
        int parkId = PARK_1.getParkId();
        String state = "AA";

        // act
        parkDao.removeParkFromState(parkId,state);

        // assert
        // check that park_state table does not contain park_id
        List<Park> parkList = parkDao.getParksByState(state);
        Assert.assertFalse("Because park deleted from park_state table", parkList.contains(PARK_1));
    }

    private void assertParksMatch(String message, Park expected, Park actual) {
        Assert.assertEquals(message, expected.getParkId(), actual.getParkId());
        Assert.assertEquals(message, expected.getParkName(), actual.getParkName());
        Assert.assertEquals(message, expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(message, expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(message, expected.getHasCamping(), actual.getHasCamping());
    }

}
