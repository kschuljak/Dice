package com.techelevator.model;

public class State {

    private String stateAbbreviation;
    private String stateName;

    public State() {}

    public State(String stateAbbreviation, String stateName) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
