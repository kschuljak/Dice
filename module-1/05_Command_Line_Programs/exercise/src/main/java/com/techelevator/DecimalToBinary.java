package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scannerInput = new Scanner(System.in);

		System.out.print("Convert Decimals to Binary");
		System.out.println();
		System.out.print("Please enter a series of decimal values, separated by spaces: ");

		String inputString = scannerInput.nextLine();
		String[] inputList = inputString.split(" ");

		for (int i = 0; i < inputList.length; i++) {

			int decimal = Integer.parseInt(inputList[i]);
			String binary =Integer.toBinaryString(decimal);
			System.out.println(inputList[i] + " in binary is " + binary);
		}

	}

}
