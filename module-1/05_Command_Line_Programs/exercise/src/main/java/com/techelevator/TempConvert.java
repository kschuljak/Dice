package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		printHeader();

		System.out.print("Please enter the temperature: ");
		String enteredTempAsString = inputScanner.nextLine();
		int enteredTemperature = Integer.parseInt(enteredTempAsString);

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String enteredUnitAsString = inputScanner.nextLine();
		char enteredUnit = enteredUnitAsString.charAt(0);

	}

	public static int convertFahrenheitToCelsius(int enteredTemperature) {
		double convertedTempTemperature = (enteredTemperature - 32)/1.8;
		return (int)(convertedTempTemperature);
	}

	public static int convertCelsiusToFahrenheit(int enteredTemperature) {
		double convertedTempTemperature = enteredTemperature * 1.8 + 32;
		return (int)(convertedTempTemperature);
	}

	public static void printHeader() {
		System.out.println();
		System.out.println("**************************************");
		System.out.println("Convert Between Celsius and Fahrenheit");
		System.out.println("**************************************");
		System.out.println();
	}

}

/*
Temperature conversion
The Fahrenheit to Celsius conversion formula is:

temperatureCelsius = (temperatureFahrenheit - 32) / 1.8
The Celsius to Fahrenheit conversion formula is:

temperatureFahrenheit = temperatureCelsius * 1.8 + 32
Write a command-line program which prompts a user to enter a temperature, and whether it's in degrees (C)elsius or (F)ahrenheit.
Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.

Please enter the temperature: 58
Is the temperature in (C)elsius, or (F)ahrenheit? F
58F is 14C.
 */
