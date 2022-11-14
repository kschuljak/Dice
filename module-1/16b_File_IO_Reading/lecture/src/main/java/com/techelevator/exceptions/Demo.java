package com.techelevator.exceptions;

import java.io.File;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Divide two numbers");
        System.out.println("------------------");

        System.out.println("Enter a number: ");
        int one = Integer.parseInt(input.nextLine());

        System.out.println("Enter another number: ");
        int two = Integer.parseInt(input.nextLine());

        int answer = one / two;
        System.out.println("------------------");
        System.out.println(answer);

        /* array out of bounds exception - runtime exception, you can run at your own risk, can be validated
        int[] numbers = new int[1];
        numbers[0] = one;
        numbers[1] = two;
         */

        /* file not found exception - exception MUST be handled, required to put in a try-catch block, cannot be validated
        String fileName = "names.txt";
        File namesFile = new File(fileName);
        Scanner fileScanner = new Scanner(namesFile);
         */

        System.out.println("Enter a file name: ");
        System.out.println("------------------");
        String filePath = input.nextLine();
        // does not create a new file or read the file, it only creates a reference to the file
        File file = new File(filePath);

        System.out.println("File exists: " + file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println("can read: " + file.canRead());
        System.out.println("can write: " + file.canWrite());
        System.out.println("is file: " + file.isFile());
        System.out.println("is directory: " + file.isDirectory());  // File IS NOT a File, it is a FileSystemObject (folder, directory, file)
        /*
        given:
            timesheet-20220101.csv;
        output:
            File exists: true
            timesheet-20220101.csv
            C:\Users\Student\workspace\katherine-schuljak-student-code\module-1\16b_File_IO_Reading\lecture\timesheet-20220101.csv
            can read: true
            can write: true
            is file: true
            is directory: false
         */

        String[] filePaths = file.list();
        if (filePaths != null) {
            for (String path : filePaths) {
                System.out.println(path);
            }
        }

        /*
        try {

        } catch (Exception ex) {

        }
         */
    }
}
