package com.techelevator.payroll;

import java.io.File;
import java.util.Scanner;

public class PayrollCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String filePath = input.nextLine();

        File file = new File(filePath);

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] columns = line.split(",");
                System.out.println(columns[0]);
                System.out.println(columns[1]);
                System.out.println(columns[2]);
                System.out.println(columns[3]);
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("Error occurred.");
        }

    }
}
