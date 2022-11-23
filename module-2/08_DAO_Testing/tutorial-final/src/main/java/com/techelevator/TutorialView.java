package com.techelevator;

import com.techelevator.model.Customer;
import com.techelevator.model.Sale;
import com.techelevator.util.BasicConsole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TutorialView {

    private final BasicConsole console;

    public TutorialView(BasicConsole console) {
        this.console = console;
    }

    public String getMenuSelection(String menuTitle, String[] options) {
        console.printBanner(menuTitle);
        return console.getMenuSelection(options);
    }

    public Customer getCustomerSelection(List<Customer> customers) {
        Customer selectedCustomer = null;

        if (customers.size() > 0) {
            console.printMessage("Customer List");
            console.printDivider();
            String[] options = new String[customers.size()];
            for (int i = 0; i < customers.size(); i++) {
                options[i] = customers.get(i).getFullName(); //.toString();
            }
            Integer selection = console.getMenuSelectionIndex(options, true);
            if (selection != null) {
                selectedCustomer = customers.get(selection);
            }
        } else {
            console.printErrorMessage("No customers found.");
        }
        return selectedCustomer;
    }

    public Sale getSaleSelection(List<Sale> sales) {
        Sale selectedSale = null;

        if (sales.size() > 0) {
            console.printMessage("Sale List");
            console.printDivider();
            String[] options = new String[sales.size()];
            for (int i = 0; i < sales.size(); i++) {
                options[i] = sales.get(i).toString();
            }
            Integer selection = console.getMenuSelectionIndex(options, true);
            if (selection != null) {
                selectedSale = sales.get(selection);
            }
        } else {
            console.printErrorMessage("No sales for customer.");
        }
        return selectedSale;
    }

    public Sale createSale(Customer customer) {

        Sale newSale = null;

        console.printMessage("Enter new sale information");
        console.printDivider();
        BigDecimal total = console.promptForBigDecimal("Total: ");
        boolean delivery = console.promptForYesNo("Delivery (Y/N)?: ");
        console.printDivider();

        console.printBlankLine();
        boolean createNewSale = console.promptForYesNo("Are you sure you wish to create the new sale (Y/N)?: ");
        if (createNewSale) {
            newSale = new Sale();
            newSale.setTotal(total);
            newSale.setDelivery(delivery);
            newSale.setCustomerId(customer.getCustomerId());
        }
        return newSale;
    }

    public void displaySale(Sale sale) {

        console.printMessage("Current sale information");
        console.printDivider();
        console.printMessage("Sale Id: " + sale.getSaleId());
        console.printMessage("Total: " + sale.getTotal());
        console.printMessage("Delivery: " + sale.isDelivery());
        console.printMessage("Customer: " + sale.getCustomerId());
    }

    public Sale updateSale(Sale sale) {

        displaySale(sale);
        console.printDivider();

        console.printBlankLine();
        console.printMessage("Update sale information");
        console.printDivider();
        Sale updatedSale = new Sale();
        updatedSale.setSaleId(sale.getSaleId());
        updatedSale.setCustomerId(sale.getCustomerId());
        updatedSale.setTotal(defaultOnEnter(console.promptForBigDecimal("Total: "), sale.getTotal()));
        updatedSale.setDelivery(console.promptForYesNo("Delivery (Y/N)?: "));
        console.printDivider();

        console.printBlankLine();
        console.printMessage("Updated campground information");
        displaySale(updatedSale);
        console.printDivider();

        console.printBlankLine();
        boolean okToUpdate = console.promptForYesNo("Are you sure you wish to update the sale (Y/N)?: ");
        if (! okToUpdate) {
            updatedSale = null;
        }
        return updatedSale;
    }

    public boolean deleteSale(Sale sale) {
        displaySale(sale);
        console.printDivider();

        console.printBlankLine();
        return console.promptForYesNo("Are you sure you wish to delete the sale (Y/N)?: ");
    }

    private String defaultOnEnter(String response, String defaultValue) {
        if (response.isBlank()) {
            return defaultValue;
        }
        else {
            return response;
        }
    }

    private LocalDate defaultOnEnter(LocalDate response, LocalDate defaultValue) {
        if (response == null) {
            return defaultValue;
        }
        else {
            return response;
        }
    }

    private Integer defaultOnEnter(Integer response, Integer defaultValue) {
        if (response == null) {
            return defaultValue;
        }
        else {
            return response;
        }
    }

    private BigDecimal defaultOnEnter(BigDecimal response, BigDecimal defaultValue) {
        if (response == null) {
            return defaultValue;
        }
        else {
            return response;
        }
    }
}
