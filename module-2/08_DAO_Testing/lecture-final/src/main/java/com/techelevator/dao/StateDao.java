package com.techelevator.dao;

import com.techelevator.model.State;

import java.util.List;

public interface StateDao {

    State getState(String stateAbbreviation);

    State getStateByCapital(int cityId);

    List<State> getStates();
}
