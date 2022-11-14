package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayNamesDemo
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the File Path: ");
        String filePath = input.nextLine();

        File file = new File(filePath);

        // declare the resource outside the try block
        Scanner fileScanner = null;

        try
        {
            // open the resource
            fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                if(line.startsWith("Wayne"))
                {
                    // simulating an error
                    throw new Exception("Invalid name in list.");
                }
                System.out.println(line);
            }

        }
        catch(FileNotFoundException ex)
        {
            System.out.println("logging file not found exception");
            System.out.println(ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println("logging general exception");
            System.out.println(ex.getMessage());
        }
        finally
        {
            // check if the resource is open
            // and the close it, if it is
            System.out.println("closing the file");
            if(fileScanner != null)
            {
                fileScanner.close();
            }
        }


    }
}
