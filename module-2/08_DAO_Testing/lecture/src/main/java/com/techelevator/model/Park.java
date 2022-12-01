package com.techelevator.model;

import java.time.LocalDate;

public class Park {

    private int parkId;
    private String parkName;
    private LocalDate dateEstablished;
    private double area;
    private boolean hasCamping;

    public Park() {}

    public Park(int parkId, String parkName, LocalDate dateEstablished, double area, boolean hasCamping) {
        this.parkId = parkId;
        this.parkName = parkName;
        this.dateEstablished = dateEstablished;
        this.area = area;
        this.hasCamping = hasCamping;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public LocalDate getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(LocalDate dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean getHasCamping() {
        return hasCamping;
    }

    public void setHasCamping(boolean hasCamping) {
        this.hasCamping = hasCamping;
    }


    @Override
    public String toString() {
        return String.format("%s (ID: %d)", parkName, parkId);
    }
}
