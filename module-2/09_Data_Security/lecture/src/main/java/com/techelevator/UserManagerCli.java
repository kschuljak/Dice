package com.techelevator;

import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.User;
import com.techelevator.dao.UserDao;
import com.techelevator.security.PasswordHasher;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserManagerCli {

    private UserDao userDao;
    private User loggedInUser;
    private Scanner userInput;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/user-manager");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        UserManagerCli application = new UserManagerCli(dataSource);
        application.run();
    }

    /**
     * Set up the daos and scanner for the application
     *
     * @param datasource the connection information to the SQL database
     */
    public UserManagerCli(DataSource datasource) {
        userDao = new JdbcUserDao(datasource, new PasswordHasher());
        userInput = new Scanner(System.in);
    }

    /**
     * The main run loop.
     */
    public void run() {
        printGreeting();

        while (true) {
            printMenu();
            String option = askPrompt();

            if ("a".equalsIgnoreCase(option)) {
                addNewUser();
            } else if ("s".equalsIgnoreCase(option)) {
                showUsers();
            } else if ("l".equalsIgnoreCase(option)) {
                loginUser();
            } else if ("q".equalsIgnoreCase(option)) {
                System.out.println("Thanks for using the User Manager!");
                break;
            } else {
                System.out.println(option + " is not a valid option. Try again!");
            }
        }
    }

    /**
     * Take a username and password from the user and check it against
     * the DAO. We don't know what's wrong about the log in, just that it
     * failed. We don't want to give an attacker any information about
     * what they got right or what they got wrong when trying this. Information
     * like that is gold to an attacker because then they know what they're
     * getting right and what they're getting wrong.
     */
    private void loginUser() {
        System.out.println("Log into the system");
        System.out.print("Username: ");
        System.out.flush();
        String username = userInput.nextLine();
        System.out.print("Password: ");
        System.out.flush();
        String password = userInput.nextLine();

        if (userDao.isUsernameAndPasswordValid(username, password)) {
            loggedInUser = new User();
            loggedInUser.setUsername(username);
            System.out.println("Welcome " + username + "!");
            System.out.println();
        } else {
            System.out.println("That log in is not valid, please try again.");
            System.out.println();
        }
    }

    /**
     * Add a new user to the system. Anyone can register a new account like
     * this. We will call save user on the DAO in order for it to save however
     * it needs to.
     */
    private void addNewUser() {
        System.out.println("Enter the following information for a new user: ");
        System.out.print("Username: ");
        System.out.flush();
        String username = userInput.nextLine();
        System.out.print("Password: ");
        System.out.flush();
        String password = userInput.nextLine();

        User user = userDao.saveUser(username, password);
        System.out.println("User " + user.getUsername() + " added with id " + user.getId() + "!");
        System.out.println();
    }

    /**
     * Show all the users that are in the database. We can't show passwords
     * because we don't have them! Passwords in the database are hashed and
     * you can see that by opening up the Visualizer and looking at what is
     * stored in the `users` table.
     *
     * We only allow access to this to logged in users. If a user isn't logged
     * in, we give them a message and leave. Having an `if` statement like this
     * at the top of the method is a common way of handling authorization checks.
     */
    private void showUsers() {
        if (loggedInUser == null) {
            System.out.println("Sorry. Only logged in users can see other users.");
            System.out.println("Hit enter to continue...");
            System.out.flush();
            userInput.nextLine();
            return;
        }

        List<User> users = userDao.getAllUsers();
        System.out.println("Users currently in the system are: ");
        for (User user : users) {
            System.out.println(user.getId() + ". " + user.getUsername());
        }
        System.out.println();
        System.out.println("Hit enter to continue...");
        System.out.flush();
        userInput.nextLine();
        System.out.println();
    }

    private void printMenu() {
        System.out.println("(A)dd a new User");
        System.out.println("(S)how all users");
        System.out.println("(L)og in");
        System.out.println("(Q)uit");
        System.out.println();
    }

    private String askPrompt() {
        String name;
        if (loggedInUser == null) {
            name = "Unauthenticated User";
        } else {
            name = loggedInUser.getUsername();
        }

        System.out.println("Welcome " + name + "!");
        System.out.print("What would you like to do today? ");
        System.out.flush();
        String selection;
        try {
            selection = userInput.nextLine();
        } catch (Exception ex) {
            selection = "*";
        }
        return selection;
    }

    private void printGreeting() {
        System.out.println("Welcome to the User Manager Application!");
        System.out.println();
    }
}
