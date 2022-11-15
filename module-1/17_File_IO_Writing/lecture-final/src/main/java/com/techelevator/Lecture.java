package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) //throws FileNotFoundException
	{
//		ProcessAllFiles();
//		WriteToFile();
//		AppendToFile();
		ReformatNames();
	}


	public static void ReformatNames()
	{
		File input = new File("files/names.txt");
		File output = new File("files/formated_names.txt");

		try(Scanner reader = new Scanner(input);
			PrintWriter writer = new PrintWriter(output))
		{
			while (reader.hasNextLine())
			{
				String line = reader.nextLine();
				String[] names = line.split(" ");

				writer.println(names[1] + ", " + names[0]);
			}

		}
		catch(IOException ex)
		{

		}
	}

	public static void AppendToFile()
	{
		Scanner input = new Scanner(System.in);
		File outFile = new File("files/answers.txt");


		// create a fileWriter and open with append set to true
		// create the printWriter from the fileWriter
		try(FileWriter fileWriter = new FileWriter(outFile, true);
			PrintWriter writer = new PrintWriter(fileWriter))
		{
			System.out.print("What is your name? ");
			String name = input.nextLine();
			writer.println("What is your name? " + name);

			System.out.print("How old are you? ");
			String age = input.nextLine();
			writer.println("How old are you? " + age);

		}
		catch (IOException ex)
		{

		}

	}


	public static void WriteToFile()
	{
		Scanner input = new Scanner(System.in);
		File outFile = new File("files/answers.txt");

		// this will ALWAYS create a new file - overwrites
		try(PrintWriter writer = new PrintWriter(outFile))
		{
			System.out.print("What is your name? ");
			String name = input.nextLine();
			writer.println("What is your name? " + name);

			System.out.print("How old are you? ");
			String age = input.nextLine();
			writer.println("How old are you? " + age);

		}
		catch (FileNotFoundException ex)
		{

		}

	}

	public static void ProcessAllFiles()
	{
		// well known path to a directory
		File directory = new File("files");

		for(File file : directory.listFiles())
		{
			if(file.getName().endsWith(".csv"))
			{
				System.out.println();
				System.out.println("Processing: " + file.getName());
				System.out.println("-------------------------------");
				try(Scanner reader = new Scanner(file))
				{
					while(reader.hasNextLine())
					{
						String line = reader.nextLine();
						System.out.println(line);
					}
				}
				catch(IOException ex)
				{

				}
				System.out.println();

				// todo: move file to the processed folder
				String path = "processed/" + file.getName();
				File newFile = new File(path);
				file.renameTo(newFile);
			}
		}

	}


	public static void FileDemo()
	{

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter a file to read: ");
		String path = userInput.nextLine();


		File file = new File(path);

		if(file.exists())
		{
			System.out.println("Name: " + file.getName());
			System.out.println("Can Read: " + file.canRead());
		}
		else
		{
			try
			{
				System.out.println("Creating file: " + file.getAbsolutePath());
				file.createNewFile();
			}
			catch(IOException ex)
			{
				System.out.println("The file could not be created.");
			}
		}


		try(Scanner reader = new Scanner(file))
		{
			while (reader.hasNextLine())
			{
				String line = reader.nextLine();
				System.out.println(line);
			}

		}
		catch(FileNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}




	}

}
