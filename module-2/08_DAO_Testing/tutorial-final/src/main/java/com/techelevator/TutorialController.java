package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.JdbcCustomerDao;
import com.techelevator.dao.JdbcSaleDao;
import com.techelevator.dao.SaleDao;
import com.techelevator.model.Customer;
import com.techelevator.model.Sale;
import com.techelevator.util.BasicConsole;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TutorialController {

    private final BasicConsole console;
    private final TutorialView view;

    private final CustomerDao customerDao;
    private final SaleDao saleDao;

    private Customer currentCustomer;
    private Sale currentSale;

    public TutorialController(BasicConsole console) throws SQLException {
        this.console = console;
        // Set View for controller
        view = new TutorialView(console);
        // Set DataSource for pizza database and assign to all the JDBC-DAOs
        DataSource dataSource = setupDataSource();
        customerDao = new JdbcCustomerDao(dataSource);
        saleDao = new JdbcSaleDao(dataSource);
    }

    /**
     * This method is called to begin the main menu loop. It's usually called from the application's
     * entry-point method (e.g., main)
     */
    public void run() {
        displayMainMenu();
    }

    public void displayMainMenu() {

        final String CUSTOMER_SELECT = "Customer - select";
        final String SALE_SELECT = "Sale - create, read, update, delete";
        final String EXIT = "Exit the program";
        final String[] MENU_OPTIONS = {CUSTOMER_SELECT, SALE_SELECT, EXIT};

        console.printBlankLine();
        console.printMessage("Welcome to the Pizza Shop.");

        boolean finished = false;
        while (!finished) {
            console.printBlankLine();
            String mainMenuTitle = "Main Menu\n" + selectedBreadCrumbs();
            String selection = view.getMenuSelection(mainMenuTitle, MENU_OPTIONS);
            if (selection.equals(CUSTOMER_SELECT)) {
                console.printBlankLine();
                List<Customer> customers = customerDao.getAllCustomers();
                Customer selectedCustomer = view.getCustomerSelection(customers);
                if (selectedCustomer == null) {
                    // Deselect current customer and sale
                    currentCustomer = null;
                    currentSale = null;
                } else if (selectedCustomer.equals(currentCustomer) == false) {
                    // Switch to selected customer and deselect sale
                    currentCustomer = selectedCustomer;
                    currentSale = null;
                }
            } else if (selection.equals(SALE_SELECT)) {
                console.printBlankLine();
                if (currentCustomer != null) {
                    saleMenu();
                } else {
                    console.printErrorMessage("No customer selected.");
                }
            } else if (selection.equals(EXIT)) {
                finished = true;
            }
        }
    }

    private void saleMenu() {

        final String SELECT = "Select sale";
        final String CREATE = "Create new sale";
        final String UPDATE = "Update selected sale";
        final String DELETE = "Delete selected sale";
        final String RETURN = "Return to Main Menu";
        final String[] MENU_OPTIONS = {SELECT, CREATE, UPDATE, DELETE, RETURN};

        boolean finished = false;
        while (!finished) {
            console.printBlankLine();
            String title = "Sale Menu\n" + selectedBreadCrumbs();
            String selection = view.getMenuSelection(title, MENU_OPTIONS);
            console.printDivider();
            console.printBlankLine();

            if (selection.equals(SELECT)) {
                // DAO in action !!!
                List<Sale> sales = saleDao.getSalesByCustomerId(currentCustomer.getCustomerId());
                Sale selectedSale = view.getSaleSelection(sales);
                if (selectedSale == null) {
                    // Deselect sale
                    currentSale = null;
                } else if (selectedSale.equals(currentSale) == false) {
                    // Switch to selected sale
                    currentSale = selectedSale;
                }
            } else if (selection.equals(CREATE)) {
                Sale newSale = view.createSale(currentCustomer);
                if (newSale != null) {
                    // DAO in action !!!
                    newSale = saleDao.createSale(newSale);
                    console.printBlankLine();
                    console.printMessage(newSale.toString() + " CREATED !!!");
                    currentSale = newSale;
                }
            } else if (selection.equals(UPDATE)) {
                if (currentSale != null) {
                    Sale updatedSale = view.updateSale(currentSale);
                    if (updatedSale != null) {
                        // DAO in action !!!
                        if (saleDao.updateSale(updatedSale)) {
                            console.printBlankLine();
                            console.printMessage(updatedSale.toString() + " UPDATED !!!");
                            currentSale = updatedSale;
                        }
                    }
                } else {
                    console.printErrorMessage("No sale selected.");
                }
            } else if (selection.equals(DELETE)) {
                if (currentSale != null) {
                    if (view.deleteSale(currentSale)) {
                        // DAO in action !!!
                        saleDao.deleteSale(currentSale.getSaleId());
                        console.printBlankLine();
                        console.printMessage(currentSale.toString() + " DELETED !!!");
                        currentSale = null;
                    }
                } else {
                    console.printErrorMessage("No sale selected.");
                }
            } else if (selection.equals(RETURN)) {
                finished = true;
            }
        }
    }

    private DataSource setupDataSource() throws SQLException {

        // Drop and then recreate the application database under separate "admin" connection
        SingleConnectionDataSource adminDataSource = new SingleConnectionDataSource();
        adminDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        adminDataSource.setUsername("postgres");
        adminDataSource.setPassword("postgres1");
        JdbcTemplate adminJdbcTemplate = new JdbcTemplate(adminDataSource);
        adminJdbcTemplate.update("DROP DATABASE IF EXISTS \"PizzaShopLite\";");
        adminJdbcTemplate.update("CREATE DATABASE \"PizzaShopLite\";");

        // Setup up the application connection
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/PizzaShopLite");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        //  Refresh the application database by running the setup script
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("PizzaShopLite.sql"));

        return dataSource;
    }

    private String selectedBreadCrumbs() {

        return "Selected: " +
                (currentCustomer != null ? currentCustomer.getCustomerId() + ":" + currentCustomer.getFullName() : "---") + " >> " +
                (currentSale != null ? currentSale.getSaleId() + ":$" + currentSale.getTotal() + ":" + currentSale.isDelivery() : "---");
    }
}
