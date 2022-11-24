package com.techelevator.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * SystemInOutConsole is a class that provides text-based UI functionality using System.in and System.out.
 *
 * This could be abstracted further to use any InputStream and PrintStream, but System.in
 * and System.out have been used intentionally to facilitate understanding by beginners.
 */

public class SystemInOutConsole implements BasicConsole {

    private final Scanner input = new Scanner(System.in);

    @Override
    public void pauseOutput() {
        System.out.print("(Press return to continue...)");
        input.nextLine();
    }

    @Override
    public void printMessage(String message) {
        printMessage(message, true);
    }

    @Override
    public void printMessage(String message, boolean withLineFeed) {
        if (withLineFeed) {
            System.out.println(message); // Print with linefeed
        }
        else {
            System.out.print(message);  // Print without linefeed
        }
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println("***" + message + "***");
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }

    @Override
    public void printBlankLines(int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println();
        }
    }

    @Override
    public void printDivider() {
        System.out.println("-----------------------------");
    }

    @Override
    public void printBanner(String message) {
        String dashes = "-".repeat(message.length());
        System.out.println(dashes);
        System.out.println(message);
        System.out.println(dashes);
    }

    @Override
    public void printBulletedItems(String[] items) {
        for (String item : items) {
            System.out.println("* " + item);
        }
    }

    @Override
    public String getMenuSelection(String[] options) {
        return getMenuSelection(options, false);
    }

    @Override
    public String getMenuSelection(String[] options, boolean allowNullResponse) {
        Integer index = getMenuSelectionIndex(options, allowNullResponse);
        return index == null ? null : options[index];
    }

    @Override
    public Integer getMenuSelectionIndex(String[] options, boolean allowNullResponse) {
        Integer result = null;
        boolean validInput = false;
        while (!validInput) {
            for (int i = 0; i < options.length; i++) {
                System.out.format("%d: %s\n", i + 1, options[i]);
            }
            Integer selection = promptForInteger("Please select: ");
            if (selection == null) {
                if (allowNullResponse) {
                    validInput = true;
                } else {
                    printErrorMessage("Please make a selection");
                }
            } else if (selection > 0 && selection <= options.length) {
                result = selection - 1;
                validInput = true;
            } else {
                printErrorMessage("Invalid selection");
            }
        }
        return result;
    }

    @Override
    public String promptForString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    @Override
    public boolean promptForYesNo(String prompt) {
        while (true) {
            String reply = promptForString(prompt);
            String upperReply = reply.toUpperCase();
            if (upperReply.startsWith("Y")) {
                return true;
            } else if (upperReply.startsWith("N")) {
                return false;
            } else {
                printErrorMessage("Please enter Y or N");
            }
        }
    }

    @Override
    public Integer promptForInteger(String prompt) {
        Integer result = null;
        String entry = promptForString(prompt);
        while (!entry.isBlank() && result == null) {
            try {
                result = Integer.parseInt(entry);
            } catch (NumberFormatException e) {
                printErrorMessage("Enter a number, please");
                entry = promptForString(prompt);
            }
        }
        return result;
    }

    @Override
    public Double promptForDouble(String prompt) {
        Double result = null;
        String entry = promptForString(prompt);
        while (!entry.isBlank() && result == null) {
            try {
                result = Double.parseDouble(entry);
            } catch (NumberFormatException e) {
                printErrorMessage("Enter a number, please");
                entry = promptForString(prompt);
            }
        }
        return result;
    }

    @Override
    public BigDecimal promptForBigDecimal(String prompt) {
        BigDecimal result = null;
        String entry = promptForString(prompt);
        while (!entry.isBlank() && result == null) {
            try {
                result = new BigDecimal(entry);
            } catch (NumberFormatException e) {
                printErrorMessage("Enter a decimal number, please");
                entry = promptForString(prompt);
            }
        }
        return result;
    }

    @Override
    public LocalDate promptForLocalDate(String prompt) {
        LocalDate result = null;
        String entry = promptForString(prompt + "(YYYY-MM-DD) ");
        while (!entry.isBlank() && result == null) {
            try {
                result = LocalDate.parse(entry);
            } catch (DateTimeParseException e) {
                printErrorMessage("Enter a date in YYYY-MM-DD format, please");
                entry = promptForString(prompt);
            }
        }
        return result;
    }

}
