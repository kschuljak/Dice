package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {
		splitFile();
	}

	public static void splitFile(){

		Scanner userInput = new Scanner(System.in);

		System.out.print("What is the source file? ");
		String sourceFile = userInput.nextLine();
		System.out.println();

		System.out.println("How many lines of text (max) should there be in each file?");
		int maxLines = Integer.parseInt(userInput.nextLine());

		File readFrom = new File(sourceFile);

		try (Scanner reader = new Scanner(readFrom)) {

			int fileNumber = 1;
			int lineNumber = 1;

			String nextFileName = getFileName(readFrom, fileNumber);
			File nextWriteFile = new File(nextFileName);

			while (reader.hasNextLine()) {
				if (lineNumber > maxLines) {
					fileNumber++;
					lineNumber = 1;
					nextFileName = getFileName(readFrom, fileNumber);
					nextWriteFile = new File(nextFileName);
				}
				try (FileWriter fileWriter = new FileWriter(nextWriteFile, true);
					 PrintWriter writer = new PrintWriter(nextWriteFile))
				{
					while (reader.hasNextLine() && lineNumber <= maxLines) {
						String line = reader.nextLine();
						writer.println(line);
						lineNumber++;
					}
				} catch (IOException ex) {
					System.out.println("Error - I/O Exception");
				}
			}

		} catch (IOException ex) {
			System.out.println("Error - IO Exception");
		}

	}

	public static String getFileName(File readFrom, int fileNumber) {
		int lastPeriod = readFrom.getName().lastIndexOf('.');
		String endingFileType = readFrom.getName().substring(lastPeriod);
		String nextWriteFileName = readFrom.getName().substring(0, lastPeriod) + "-" + fileNumber + endingFileType;
		return nextWriteFileName;
	}



}
