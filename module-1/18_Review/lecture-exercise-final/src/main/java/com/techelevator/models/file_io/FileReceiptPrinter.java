package com.techelevator.models.file_io;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.techelevator.models.ShoppingCart;

/**
 * Responsibilities:
 *      create a new receipt file and add the receipt details
 * 
 * Dependencies:
 *      ShoppingCart
 *      Product
 */
public class FileReceiptPrinter 
{
    
    public void createReceipt(ShoppingCart cart, BigDecimal paymentAmount, BigDecimal change)
    {
        // create a new file in the "receipt folder"
        // the file name will be the current date and time 20210106_140312.txt
        String receiptPath = "receipts/" + receiptName();
        File file = new File(receiptPath);

        try(PrintWriter fileWriter = new PrintWriter(file))
        {
            // print all shopping cart items as line items 
            //      - Product name, category, unit price, quantity
            // print the shopping cart total amount
            // print the payment amount
            // print the change given
            
        }
        catch(Exception ex)
        {
            // log any exceptions here
        }
    }

    private String receiptName()
    {
        LocalDateTime time = LocalDateTime.now();

        String dateString = time.format(DateTimeFormatter.ISO_DATE)
                                .replace("-", "");
                                
        String timeString = time.format(DateTimeFormatter.ISO_LOCAL_TIME)
                                .replace(":","")
                                .substring(0,6);

        return dateString + "_" + timeString + ".txt";
    }
}
