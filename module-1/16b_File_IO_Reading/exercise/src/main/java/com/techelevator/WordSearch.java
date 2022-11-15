package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {

		// scanner for user input
		Scanner input = new Scanner(System.in);

		// get input from user - file to search
		// create file reference to said file
		System.out.println("Enter a file path for the desired file: ");
		String filePath = input.nextLine().strip();
		File fileToSearch = new File(filePath);

		// get input from user - what word to search for
		// store word in variable
		System.out.println();
		System.out.println("What word would you like to search for? ");
		String wordToSearchFor = input.nextLine();

		// get input from user - if word search should ignore case
		// store boolean in variable
		System.out.println();
		System.out.println("Should the search be case sensitive? (Y/N)");
		System.out.println();
		String makeCaseInsensitive = input.nextLine();

		boolean ignoreCase = makeCaseInsensitive.equalsIgnoreCase("N");

		// scan file
		// for each occurrence of the searched word
		// output line number + line contents
		int lineCount = 1;
		if (wordToSearchFor != null && wordToSearchFor.length() >= 1 && fileToSearch.isFile()) {
			try (Scanner fileScanner = new Scanner(fileToSearch)) {
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					if (!ignoreCase && line.contains(wordToSearchFor)) System.out.println(lineCount + ") " + line);
					if (ignoreCase && line.toLowerCase().contains(wordToSearchFor.toLowerCase())) {
						System.out.println(lineCount + ") " + line);
					}
					lineCount++;
				}
			} catch (FileNotFoundException ex) {
				System.out.println("error - file not found at given file path");
			} catch (Exception ex) {
				System.out.println("an error has occurred");
			}
		}
	}

}
