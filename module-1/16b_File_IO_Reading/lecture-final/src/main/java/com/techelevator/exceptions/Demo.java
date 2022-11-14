package com.techelevator.exceptions;

import java.io.File;
import java.security.spec.ECField;
import java.util.Scanner;

public class Demo
{


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String filePath = input.nextLine();
        // File IS NOT a File
        // it is a FileSystemObject
        File file = new File(filePath);

        System.out.println("File exists: " + file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println("can read: " + file.canRead());
        System.out.println("is file: " + file.isFile());
        System.out.println("is directory: " + file.isDirectory());

        // this gets us an array of Strings
        // with all of the file and directory names
        // in the current directory
        if(!file.isFile())
        {
            String[] filePaths = file.list();
            for (String path : filePaths)
            {
                System.out.println(path);
            }
        }


        try
        {
        }
        catch(Exception ex)
        {
            System.out.println("An error has occurred");
            System.out.println(ex.getMessage());
        }
    }
}
