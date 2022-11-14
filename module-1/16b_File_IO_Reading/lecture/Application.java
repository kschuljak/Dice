package com.techelevator.payroll;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        // timesheet-20220201.csv
        Scanner input = new Scanner(System.in);

        System.out.print("Which file do you want to process? ");
        String fileName = input.nextLine();

        File timesheet = new File(fileName);

        try(Scanner timesheetScanner = new Scanner(timesheet))
        {
            // read and skip the first line
            timesheetScanner.nextLine();

            while(timesheetScanner.hasNextLine())
            {
                try
                {
                    String line = timesheetScanner.nextLine();
                    String[] columns = line.split(",");

                    int id = Integer.parseInt(columns[0]);
                    String name = columns[1];
                    BigDecimal hoursWorked = new BigDecimal(columns[2]);
                    BigDecimal payRate = new BigDecimal(columns[3]);


//                    BigDecimal totalPay = hoursWorked.multiply(payRate);
//                    System.out.println(name + " worked " + hoursWorked + " hours, and earned $" + totalPay);

                    TimeEntry entry = new TimeEntry(id, name, hoursWorked, payRate);

                    if(hoursWorked.intValue() < 0 )
                    {
                        throw new PayrollException(entry);
                    }

                    System.out.println();
                    System.out.println("Processing Payroll: ");
                    System.out.println(entry);
                }
                catch (PayrollException e)
                {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println("Hours Entered: " + e.getBadEntry().getHours());
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
