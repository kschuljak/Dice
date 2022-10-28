package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		printHeader();

		System.out.print("Please enter the length: ");
		String stringLength = inputScanner.nextLine();
		double length = Double.parseDouble(stringLength);

		System.out.print("Is the measurement in (m)eters or (f)eet? ");
		String stringUnit = inputScanner.nextLine();
		char unit = stringUnit.charAt(0);

		double convertedNumber;

		if (unit == 'f' || unit == 'F') {
			convertedNumber = feetToMeters(length);
			System.out.println(length + " feet = " + convertedNumber + " meters ");
		} else if (unit == 'm' || unit == 'M') {
			convertedNumber = metersToFeet(length);
			System.out.println(length + " meters = " + convertedNumber + " feet ");
		} else {
			System.out.println("Error");
		}
	}

	public static double feetToMeters(double feet) {
		return feet * 0.3048;
	}


	public static double metersToFeet(double meters) {
		return meters * 3.2808399;
	}

	public static void printHeader() {
		System.out.println();
		System.out.println("*******************************");
		System.out.println("Convert Between Feet and Meters");
		System.out.println("*******************************");
		System.out.println();
	}

}

/*
Linear conversion
Write a program that converts meters to feet and vice-versa.

The foot to meter conversion formula is:	m = f * 0.3048

The meter to foot conversion formula is:	f = m * 3.2808399

Write a command-line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet.
Convert the length to the opposite measurement, and display the old and new measurements to the console.

Please enter the length: 58
Is the measurement in (m)eter, or (f)eet? f
58f is 17m.
 */
