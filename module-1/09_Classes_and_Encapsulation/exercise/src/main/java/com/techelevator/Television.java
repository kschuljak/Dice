package com.techelevator;

public class Television {

    // instance variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    // getters
    public boolean isOn() {
        return isOn;
    }
    public int getCurrentChannel() {
        return currentChannel;
    }
    public int getCurrentVolume() {
        return currentVolume;
    }

    // methods
    public void turnOff() {
        this.isOn = false;
    }
    public void turnOn() {
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }
    public void changeChannel(int newChannel) {
        if (isOn) {
            if (newChannel >= 3 && newChannel <= 18) {
                this.currentChannel = newChannel;
            }
        }
    }
    public void channelUp() {
        if (isOn) {
            int newChannel = currentChannel + 1;
            if (newChannel > 18) {
                this.currentChannel = 3;
            } else {
                this.currentChannel = newChannel;
            }
        }
    }
    public void channelDown() {
        if (isOn) {
            int newChannel = currentChannel - 1;
            if (newChannel < 3) {
                this.currentChannel = 18;
            } else {
                this.currentChannel = newChannel;
            }
        }
    }
    public void raiseVolume() {
        int newVolume = currentVolume + 1;
        if (isOn && newVolume <= 10) {
            this.currentVolume = newVolume;
        }
    }
    public void lowerVolume() {
        int newVolume = currentVolume - 1;
        if (isOn && newVolume >= 0) {
            this.currentVolume = newVolume;
        }
    }


}
