package com.techelevator;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		// character array - [J, e, s, s, i, e]
		char[] nameChars = {'J', 'e', 's', 's', 'i', 'e'};

		// string - creates byte array [74, 101, 115, 115, 105, 101]
		String name = "Jessie";

		String name2 = "Jessie";
		boolean areEqual = name == name2;  // TRUE
		// Why True??? Because:
		// any time you create a string with a literal,
		// every time you reuse that literal the variable will point to the same constant
		// so name == name2, since they both point to the same "Jessie"

		String name3 = new String(nameChars);
		boolean areAlsoEqual = name == name3;  // FALSE
		// Why False? Because:
		// string not declared with string literal (constant),
		// memory address points to a new string value on the heap

		boolean areValuesEqual = name.equals(name3);  // TRUE
		// Why True? Because:
		// .equals() compares values, not pointers (aka memory addresses)

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes).  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */
		String myName = "Katherine";
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a file name (with path): ");
		String fileName = input.nextLine();

		// first, strip any trailing spaces
		// then, check if fileName ends with .txt
		// methods executed in order of chain: 1st).strip() & 2nd).endsWith()
		if(fileName.strip().endsWith(".txt")){
			System.out.println("I can process");
		} else {
			System.out.println("I can't process");
		}

		// indexOf checks for first occurrence of a character
		// returns start index || -1
		int firstIndex = fileName.indexOf('\\');

		// .substring(start index inclusive, optional end index noninclusive)
		String partialPath = fileName.substring(firstIndex + 1);
		int secondIndex = partialPath.indexOf('\\');
		String firstFolder = partialPath.substring(0, secondIndex);
		System.out.println("First folder: " + firstFolder);

		int lastIndex = fileName.lastIndexOf('\\');
		String fileNameOnly = fileName.substring(lastIndex + 1);
		System.out.println("File name: " + fileNameOnly);

		// convert Windows file into Linux file
		String linuxPath = fileName.replace('\\', '/');
		System.out.println("New path: " + linuxPath);

		// same thing using substrings
		// print out each portion of the path, separating by \
		String tempFilePath = fileName;
		while (tempFilePath.indexOf('\\') >= 0){
			int indexOfSlash = tempFilePath.indexOf('\\');
			String part = tempFilePath.substring(0, indexOfSlash);
			System.out.println(part);
			tempFilePath = tempFilePath.substring(indexOfSlash + 1);
		}
		System.out.println(tempFilePath);

		System.out.println();

		String[] parts = fileName.split("\\\\");
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			System.out.println(part);
		}



		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 * -- new versions of trim
		 * strip
		 * stripLeading
		 * stripTrailing
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the () method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
