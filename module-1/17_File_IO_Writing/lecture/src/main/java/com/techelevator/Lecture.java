package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {        // throws IOException { 	<- suppresses FileNotFound exception in catch block
		reformatNames();
	}

	// read from file1 and write to file2
	public static void reformatNames() {
		File input = new File("files/names.txt");
		File output = new File("files/new_names.txt");

		try (Scanner reader = new Scanner(input);
			PrintWriter writer = new PrintWriter(output)){

			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] names = line.split(" ");

				writer.println(names[1] + ", " + names[0]);
			}

		} catch (IOException ex) {

		}
	}


	public static void appendToFile(){

		Scanner userInput = new Scanner(System.in);
		File writeFile = new File("files/answers.txt");

		/*
		// to append to a file:
		// create a new fileWriter, with append set to true
		// create printWriter from fileWriter

		try (FileWriter fileWriter = new FileWriter(writeFile, true);
			 PrintWriter writer = new PrintWriter(writeFile)) {

		alt - can use below example to create file output stream
		 */

		try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(writeFile, true))){
			System.out.print("What is your name? ");
			String name = userInput.nextLine();

			dataOutput.println("What is your name? " + name);

			System.out.print("How old are you? ");
			String age = userInput.nextLine();

			dataOutput.println("How old are you? " + age);

		} catch (IOException ex) {
			System.out.println("Error - file I/O");
		}
	}



	public static void writeToFile(){

		Scanner userInput = new Scanner(System.in);
		File writeFile = new File("files/answers.txt");

		// this will always create a new file - overwrites old file is present
		try (PrintWriter writer = new PrintWriter(writeFile)) {

			System.out.print("What is your name? ");
			String name = userInput.nextLine();

			writer.println("What is your name? " + name);

			System.out.print("How old are you? ");
			String age = userInput.nextLine();

			writer.println("How old are you? " + age);

		} catch (FileNotFoundException ex) {
			System.out.println("Error");
		}

	}


	public static void ProcessAllFiles(){

		// well known path to a directory (hardcoded file path)
		File directory = new File("files");

		if (directory.isDirectory()) {
			for (File file : directory.listFiles()) {

				if (file.getName().endsWith(".csv")) {
					System.out.println("Processing: " + file.getName());

					try (Scanner reader = new Scanner(file)) {

						while (reader.hasNextLine()) {
							String line = reader.nextLine();
							System.out.println(line);
						}

					} catch (IOException ex) {
						System.out.println("Error has occurred.");
					}
					// move processed files to a new directory
					String path = "processed/" + file.getName();
					File newFile = new File(path);
					file.renameTo(newFile);
				}

			}
		}

	}



	public static void FileDemo(){

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter a file path: ");
		String path = userInput.nextLine();

		File file = new File(path);
		if(file.exists()) {
			System.out.println("File Name: " + file.getName());
			System.out.println("Can Read: " + file.canRead());
		} else {
			System.out.println("No such file at given path. ");
			try {
				file.createNewFile();
				System.out.println("New file at given path created.");
			} catch (IOException ex){
				System.out.println("The file could not be created.");
			}
		}

		try(Scanner reader = new Scanner(file)) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}


	}

}
