package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		System.out.println("Print the Fibonacci Sequence (ending at entered number)");
		System.out.println("-------------------------------------------------------");

		System.out.print("Please enter a number: ");

		String enteredNumberAsString = inputScanner.nextLine();
		int enteredNumberAsInt = Integer.parseInt(enteredNumberAsString);


		if (enteredNumberAsInt <= 0) System.out.print("0, 1");
		else if (enteredNumberAsInt == 1) System.out.print("0, 1, 1");
		else {
			System.out.print("0, 1, 1, ");
			int firstNumber = 1;
			int secondNumber = 1;

			while (secondNumber <= enteredNumberAsInt) {

				int nextNumber = firstNumber + secondNumber;

				if (nextNumber <= enteredNumberAsInt) {

					System.out.print(nextNumber);
					int nextNextNumber = secondNumber + nextNumber;
					if (nextNextNumber <= enteredNumberAsInt) {
						System.out.print(", ");
					}
				}
				firstNumber = secondNumber;
				secondNumber = nextNumber;
			}
		}

	}

}
