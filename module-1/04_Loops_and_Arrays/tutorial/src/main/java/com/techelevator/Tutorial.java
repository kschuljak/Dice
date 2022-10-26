package com.techelevator;

public class Tutorial {

    public static void main(String[] args) {

        int i;

        // increment a value
        for (i = 0; i <= 5; i++) {
            System.out.println(i);
        }

        // decrement a value
        for (i = 10; i >= 0; i--) {
            System.out.println(i);
        }

        // create an array
        int[] forecastTemperatures = new int[5];
        forecastTemperatures[0] = 72;
        forecastTemperatures[1] = 78;
        forecastTemperatures[2] = 58;
        forecastTemperatures[3] = 79;
        forecastTemperatures[4] = 74;

        // change an element of an array by index
        forecastTemperatures[2] += 10;

        // loop through an array
        for (i = 0; i < forecastTemperatures.length; i++) {
            System.out.println(forecastTemperatures[i]);
        }

        // find the largest element of an array
        int highestTemperatureValue = forecastTemperatures[0];
        int highestTemperatureIndex = 0;
        for (int j = 1; j < forecastTemperatures.length; j++) {
            if (forecastTemperatures[j] > highestTemperatureValue) {
                highestTemperatureValue = forecastTemperatures[j];
                highestTemperatureIndex = j;
            }
        }
        System.out.println("The highest temperature is " + highestTemperatureValue);
        System.out.println("The highest temperature is in " + (highestTemperatureIndex + 1) + " days");



    }
}
