package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		runFizzBuzz();
	}


	public static void runFizzBuzz() {

		Scanner userInput = new Scanner(System.in);

		System.out.print("What is the destination file? ");
		String destinationFile = userInput.nextLine();

		File writeFile = new File(destinationFile);

		try (PrintWriter writer = new PrintWriter(writeFile)) {

			for (int i = 1; i <= 300; i++) {
				int thisNum = i;
				if (thisNum % 3 == 0 && thisNum % 5 == 0) writer.println("FizzBuzz");
				else if (thisNum % 3 == 0) writer.println("Fizz");
				else if (thisNum % 5 == 0) writer.println("Buzz");
				else writer.println(thisNum);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error - File Not Found Exception");
		}
	}


}
