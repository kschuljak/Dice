package com.techelevator;

public class Elevator {

    // instance variables
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    // getters
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public boolean isDoorOpen() {
        return doorOpen;
    }

    // constructor
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
        this.currentFloor = 1;
    }

    // methods
    public void openDoor() {
        this.doorOpen = true;
    }
    public void closeDoor() {
        this.doorOpen = false;
    }
    public void goUp(int desiredFloor) {
        if (!doorOpen && desiredFloor <= numberOfFloors) {
            if (desiredFloor > currentFloor) this.currentFloor = desiredFloor;
        }
    }
    public void goDown(int desiredFloor){
        if (!doorOpen && desiredFloor > 0) {
            if (desiredFloor < currentFloor) this.currentFloor = desiredFloor;
        }
    }
}
