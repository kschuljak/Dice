package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		System.out.println("Print the Fibonacci Sequence (ending at entered number)");
		System.out.println("-------------------------------------------------------");

		System.out.print("Please enter a number: ");

		// take user input and parse to integer
		String enteredNumberAsString = inputScanner.nextLine();
		int enteredNumberAsInt = Integer.parseInt(enteredNumberAsString);

		// case handling if number entered == 0 (or negative)
		if (enteredNumberAsInt <= 0) System.out.print("0, 1");
		// case handling if number entered == 1
		else if (enteredNumberAsInt == 1) System.out.print("0, 1, 1");
		// case handling for all remaining numbers
		else {
			// begins the fibonacci sequence
			System.out.print("0, 1, 1, ");
			int firstNumber = 1;
			int secondNumber = 1;

			// continues the fibonacci sequence up to (and including) entered number
			while (secondNumber <= enteredNumberAsInt) {

				// adds two preceding numbers to create next number in fibonacci sequence
				int nextNumber = firstNumber + secondNumber;

				// does not display the next number if end has been reached
				if (nextNumber <= enteredNumberAsInt) {

					System.out.print(nextNumber);
					// checks if the calculated number is the end of the sequence
					// if not, outputs ", " to create logical grammatical output
					int nextNextNumber = secondNumber + nextNumber;
					if (nextNextNumber <= enteredNumberAsInt) {
						System.out.print(", ");
					}
				}
				// resets the numbers to be added together for the next iteration
				firstNumber = secondNumber;
				secondNumber = nextNumber;
			}
		}

	}

}

/*
Write a command-line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number:
Please enter a number: 17
0, 1, 1, 2, 3, 5, 8, 13
```
If the input is a number that appears in the Fibonacci sequence, print the sequence up to *and including* that number:
Please enter a number: 34
0, 1, 1, 2, 3, 5, 8, 13, 21, 34
```
The Fibonacci sequence always starts with 0 and 1. If the input is 0 or a negative number, print "0, 1":
Please enter a number: 0
0, 1
```
If the input is 1, print "0, 1, 1":
Please enter a number: 1
0, 1, 1
 */
