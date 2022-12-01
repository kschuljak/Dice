package com.techelevator.dao;

import com.techelevator.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JdbcStateDaoTests extends BaseDaoTests
{

    private static final State STATE_A = new State("AA", "State A");
    private static final State STATE_B = new State("BB", "State B");
    private static final State STATE_C = new State("CC", "State C");

    private static final List<State> STATES = List.of(STATE_A, STATE_B, STATE_C);
    private static final Map<Integer, State> STATE_CAPITALS = Map.of(
            1, STATE_A,
            2, STATE_B,
            3, STATE_C
    );

    private JdbcStateDao stateDao;

    @Before
    public void setup()
    {
        stateDao = new JdbcStateDao(dataSource);
    }

    @Test
    public void getState_returns_correct_state_for_abbreviation()
    {
        for (State expectedState : STATES)
        {
            // arrange
            String abbreviation = expectedState.getStateAbbreviation();

            // act
            State actualState = stateDao.getState(abbreviation);

            // assert
            String message = "Because I searched for state: " + abbreviation;
            assertStatesMatch(message, expectedState,actualState);

        }
    }

    @Test
    public void getState_returns_null_when_abbreviation_not_found()
    {
        // arrange
        String abbreviation = "XX";

        // act
        State actualState = stateDao.getState(abbreviation);

        // assert
        String message = "Because state 'XX' should not befound in the database";
        Assert.assertNull(message, actualState);
    }

    @Test
    public void getStateByCapital_returns_correct_state_for_capital_id()
    {
        for (Integer cityId : STATE_CAPITALS.keySet())
        {
            // arrange
            State expectedState = STATE_CAPITALS.get(cityId);

            // act
            State actualState = stateDao.getStateByCapital(cityId);

            // assert
            String message = "Because city " + cityId + " should be the capital of " + expectedState.getStateName();
            assertStatesMatch(message, expectedState, actualState);
        }
    }

    @Test
    public void getStateByCapital_returns_null_for_invalid_capital_city_id()
    {
        // arrange
        // city 99 is not a real city in the database
        int cityId = 99;

        // act
        State actual = stateDao.getStateByCapital(cityId);

        // assert
        String message = "Because city id 99 is not in the database and should not be the capital of a state.";
        Assert.assertNull(message, actual);
    }

    @Test
    public void getStateByCapital_returns_null_for_valid_city_but_non_capital_city_id()
    {
        // arrange
        // city 4 is in the database but is not the capital of any state
        int cityId = 4;

        // act
        State actual = stateDao.getStateByCapital(cityId);

        // assert
        String message = "Because city id 4 should not be the capital of a state.";
        Assert.assertNull(message, actual);

    }

    @Test
    public void getStates_returns_all_states()
    {
        // act
        List<State> actualStates = stateDao.getStates();

        // assert
        String message = "Because there should be " + STATES.size() + " states in the database";
        Assert.assertEquals(message, STATES.size(), actualStates.size());

        for(int i = 0; i < STATES.size(); i++)
        {
            State expected = STATES.get(i);
            State actual = actualStates.get(i);

            message = "Because I am comparing states at index: " + i;
            assertStatesMatch(message, expected, actual);
        }
    }

    private void assertStatesMatch(String message, State expected, State actual)
    {
        Assert.assertEquals(message, expected.getStateAbbreviation(), actual.getStateAbbreviation());
        Assert.assertEquals(message, expected.getStateName(), actual.getStateName());
    }
}
