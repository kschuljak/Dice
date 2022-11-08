package com.shippingcompany.delivery;

import com.shippingcompany.Shipment;

import java.time.LocalDateTime;

public abstract class Delivery {

    private String origin;
    private String destination;
    private int distance;
    private Shipment shipment;

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Shipment getShipment() {
        return shipment;
    }
    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    // abstract method
    public abstract int getDuration();

    // method
    protected int convertHoursToMinutes(double decimalHours) {
        int hours = (int) decimalHours;
        int minutes = (int) Math.round((decimalHours - hours) * 60);
        return hours* 60 * minutes;
    }

    // final method
    public final LocalDateTime getExpectedArrival(LocalDateTime departure) {
        return departure.plusMinutes(getDuration());
    }
}
