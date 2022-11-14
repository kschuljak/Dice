package com.techelevator.payroll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PayrollCalculator
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String filePath = input.nextLine();

        File file = new File(filePath);

        // try for the entire file
        try(Scanner reader = new Scanner(file))
        {
            // process the payroll for each employee
            // skip the first line
            reader.nextLine();
            while (reader.hasNextLine())
            {
                // try per line
                try
                {
                    String line = reader.nextLine();
//                    String[] columns = line.split("\\|");
                    String[] columns = line.split(",");

                    Timesheet timesheet = new Timesheet();
                    timesheet.setId(columns[0]);
                    timesheet.setName(columns[1]);
                    timesheet.setHours(Double.parseDouble(columns[2]));
                    timesheet.setRate(Double.parseDouble(columns[3]));

                    System.out.println(timesheet.getName() + " $" + timesheet.getGrossPay());
                }
                catch(TimesheetNegativeHoursException ex)
                {
                    System.out.println(ex.getMessage() + " " + ex.getTimesheet().getId() + " " + ex.getTimesheet().getHours());
                }
            }

        }
        catch (FileNotFoundException ex)
        {

        }

    }
}
