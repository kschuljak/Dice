package com.techelevator;

public class Airplane {

    // instance variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;

    // plane number - getter
    public String getPlaneNumber() {
        return planeNumber;
    }

    // total first class seats - getter
    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    // booked first class seats - getter
    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    // available first class seats (derived) - getter
    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    // total coach seats - getter
    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    // booked coach seats - getter
    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    // available coach seats (derived) - getter
    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    // constructor
    // arguments: plane number, total first class seats, total coach seats
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    // method reserve seats
    // input: boolean for first class, total number of seats
    // output: boolean if enough seats are available to make the reservation
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            int firstClassSeatsRequested = bookedFirstClassSeats + totalNumberOfSeats;
            if (firstClassSeatsRequested < totalFirstClassSeats) {
                this.bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
        }
        if (!forFirstClass) {
            int coachSeatsRequested = bookedCoachSeats + totalNumberOfSeats;
            if (coachSeatsRequested < totalCoachSeats) {
                this.bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }
}
