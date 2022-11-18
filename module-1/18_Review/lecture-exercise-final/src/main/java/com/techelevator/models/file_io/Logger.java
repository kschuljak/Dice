package com.techelevator.models.file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Responsibilities:
 *      log messages to a log file
 * 
 * Details:
 *      All log files have the name of the current date (i.e. 2021-01-06) end with a .log extension
 *      The constructor requires the name of a directory which will determine where the log file is created.
 */
public class
Logger
{
    private static final String FILE_EXTENSION = ".log";

    private String directory;

    public Logger(String directory)
    {
        this.directory = directory;
    }

    public void logMessage(String message)
    {
        String fileName = LocalDate.now().format(DateTimeFormatter.ISO_DATE); //YYYY-MM-DD
        String logFilePath = directory + "/" + fileName + FILE_EXTENSION;
        File logFile = new File(logFilePath);

        try(FileWriter fileWriter = new FileWriter(logFile,true);
            PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            // open the log file to append and write the message
            // format: <current time> <message>
            String timeStamp = LocalDate.now().toString();
            writer.println(timeStamp + " " + message);
        }
        catch (IOException ex)
        {
            // swallow the exception
        }
    }
    
    
}
