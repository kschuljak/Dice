package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		printHeader();

		// takes user input and converts to double
		System.out.print("Please enter the temperature: ");
		String enteredTempAsString = inputScanner.nextLine();
		double enteredTemperature = Double.parseDouble(enteredTempAsString);

		// takes user input and converts to character
		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String enteredUnitAsString = inputScanner.nextLine();
		char enteredUnit = enteredUnitAsString.charAt(0);

		// initializes double to hold result
		double convertedTemperature;
		// initializes character to hold unit of result
		char outputUnit;

		// performs conversion and sets unit based on input unit, otherwise displays an error
		if (enteredUnit == 'C' || enteredUnit == 'c'){
			convertedTemperature = convertCelsiusToFahrenheit(enteredTemperature);
			outputUnit = 'F';
		} else if (enteredUnit == 'F' || enteredUnit == 'f') {
			convertedTemperature = convertFahrenheitToCelsius(enteredTemperature);
			outputUnit = 'C';
		} else {
			System.out.println("Error - entered unit must be 'F' or 'C' ");
			return;
		}

		// converts result into integer for output
		int convertedTempAsInt = (int)(convertedTemperature);

		System.out.print(enteredTempAsString + enteredUnit + " is " + convertedTempAsInt + outputUnit);
	}

	// function - converts fahrenheit to celsius
	public static double convertFahrenheitToCelsius(double enteredTemperature) {
		return (enteredTemperature - 32)/1.8;
	}

	// function - converts celsius to fahrenheit
	public static double convertCelsiusToFahrenheit(double enteredTemperature) {
		return enteredTemperature * 1.8 + 32;
	}

	// function - prints header
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
