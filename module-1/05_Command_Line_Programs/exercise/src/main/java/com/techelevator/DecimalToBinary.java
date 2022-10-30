package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scannerInput = new Scanner(System.in);

		System.out.println("Convert Decimals to Binary");
		System.out.println("--------------------------");
		System.out.println();
		System.out.print("Please enter a series of decimal values, separated by spaces: ");


		// take input string and separate into string array
		String inputString = scannerInput.nextLine();
		String[] inputListAsString = inputString.split(" ");

		// create int array from string array
		Integer[] inputListAsInt = new Integer[inputListAsString.length];
		for (int i = 0; i < inputListAsString.length; i++) {
			inputListAsInt[i] = Integer.parseInt(inputListAsString[i]);
		}

		// create empty string to store binary (reversed, separated by spaces)
		String binaryString = "";

		// go through integer array, divide number by 2 and concatenate remainder to end of binary string
		for (int i = 0; i < inputListAsInt.length; i++) {
			int number = inputListAsInt[i];
			int numberToDisplay = inputListAsInt[i];
			while (number > 0) {
				int newNumber = number / 2;
				int remainder = number % 2;
				binaryString += String.valueOf(remainder) + " ";
				number = newNumber;
			}
			// split binary string into string array
			// reverse through string array, convert to integer, and add to int array starting from front
			String[] binaryAsStringArray = binaryString.split(" ");
			Integer[] binaryAsIntegerArray = new Integer[binaryAsStringArray.length];
			int startAtFrontIndex = 0;
			int startAtEndIndex = binaryAsStringArray.length - 1;
			for (int j= 0; j < binaryAsStringArray.length; j++) {
				binaryAsIntegerArray[startAtEndIndex] = Integer.parseInt(binaryAsStringArray[startAtFrontIndex]);
				startAtFrontIndex++;
				startAtEndIndex--;
			}
			System.out.print(numberToDisplay + " in binary is ");
			for (int k = 0; k < binaryAsIntegerArray.length; k++) {
				System.out.print(binaryAsIntegerArray[k]);
			}
			binaryString = "";
			System.out.println();
		}

	}

}
// Integer.toBinaryString();

// to convert decimal to binary:
// divide number by 2
// add remainder to front of binary number
// reassign the number to the result of the division
// repeat until the number is 0
// ex:
// 38 / 2 = 19		&& 		38 % 2 = 0
// 19 / 2 = 9 		&& 		19 % 2 = 1
//  9 / 2 = 4 		&& 		 9 % 2 = 1
//  4 / 2 = 2		&&		 4 % 2 = 0
//  2 / 2 = 1		&&		 2 % 2 = 0
//  1 / 2 = 0		&&		 1 % 2 = 1
// 38  ---> 1 0 0 1 1 0
