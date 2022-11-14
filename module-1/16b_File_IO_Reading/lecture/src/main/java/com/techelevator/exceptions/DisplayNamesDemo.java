package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayNamesDemo {

    public static void main(String[] args) {

        // this scanner represents user input stream
        Scanner input = new Scanner(System.in);

        // Step 1. prompt user for file name
        System.out.println("Enter the File Path: ");
        String filePath = input.nextLine();

        // Step 1b. create File object from user input
        File file = new File(filePath);

        /* make sure you close any files that you open!
           - in this example, if you throw an exception, fileScanner.close does not execute

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("Wayne")) {
                    // simulating an error
                    throw new Exception("Invalid name in list");
                }
                System.out.println(line);
            }
            fileScanner.close();

        } catch (FileNotFoundException ex) {
            System.out.println("logging file not found exception");

        } catch (Exception ex) {
            System.out.println("logging general exception");
        }
         */

        // this scanner represents file stream
        // Step 2. create a Scanner from the File
        try (Scanner fileScanner = new Scanner(file)) {

            // Step 3. loop until there is nothing left to read
            while (fileScanner.hasNextLine()) {
                // Step 3b. read the line into memory and use it
                String line = fileScanner.nextLine();
                if (line.startsWith("Wayne")) {
                    // simulating an error
                    throw new Exception("Invalid name in list.");
                }
                System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("logging file not found exception");

        } catch (Exception ex) {
            System.out.println("logging general exception");
            System.out.println(ex.getMessage());
        }
    }

    /* Legacy:
    File fileName = new File(filePath)

    // declare resource outside of try block
    Scanner fileScanner = null;

    try {
        // open resource
        Scanner fileScanner = new Scanner(fileName);

    } catch {
        // ...

    } finally {

        // check if resource is open
        if (fileScanner != null) {

            // close resource
            fileScanner.close();
        }
    }
     */
}
