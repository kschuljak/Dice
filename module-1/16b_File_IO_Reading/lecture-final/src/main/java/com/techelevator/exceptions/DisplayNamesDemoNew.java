package com.techelevator.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DisplayNamesDemoNew
{
    public static void main(String[] args)
    {
        // first scanner - user input stream
        Scanner input = new Scanner(System.in);

        // step 1. prompt user for the file name
        System.out.print("Enter the File Path: ");
        String filePath = input.nextLine();

        // step 1b. create a File object form the input
        File file = new File(filePath);


        // try with resources
        // declare and open the resource as part of the try block
        // fileScanner - read the file stream
        // step 2. create a scanner from the File
        int wordCount = 0;
        try (Scanner fileScanner = new Scanner(file))
        {
            // step 3. loop until there is nothing left to read
            while(fileScanner.hasNextLine())
            {
                // step 3b. read the current line into memory
                String line = fileScanner.nextLine();
                // split line on space
                String[] words = line.split(" ");
                wordCount += words.length;
                System.out.println(line);
            }

        }
        catch(FileNotFoundException ex)
        {
            System.out.println("logging file not found exception");
            System.out.println(ex.getMessage());
        }

        System.out.println("There are " + wordCount + " words in the story.");



    }
}
