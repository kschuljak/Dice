package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.model.User;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.security.PasswordHasher;

public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private PasswordHasher passwordHasher;

    /**
     * Create a new user dao with the supplied data source and the password hasher
     * that will salt and hash all the passwords for users.
     *
     * @param dataSource an SQL data source
     * @param passwordHasher an object to salt and hash passwords
     */
    public JdbcUserDao(DataSource dataSource, PasswordHasher passwordHasher) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.passwordHasher = passwordHasher;
    }

    /**
     * Save a new user to the database. The password that is passed in will be
     * salted and hashed before being saved. The original password is never
     * stored in the system. We will never have any idea what it is!
     *
     * @param userName the username to give the new user
     * @param password the user's password
     * @return the new user
     */
    @Override
    public User saveUser(String userName, String password) {

        // step 1 - create a new random salt
        byte[] salt = passwordHasher.generateRandomSalt();
        // step 2 - hash password using new generated salt
        String hashedPassword = passwordHasher.computeHash(password, salt);
        // step 3 = convert salt (byte array) into a string to save in the database
        String saltString = new String(Base64.encode(salt));

        String sql = "INSERT INTO users(username, password, salt) " +
                     " VALUES (?, ?, ?) RETURNING id";
        int newId = jdbcTemplate.queryForObject(
                sql,
                int.class,
                userName,
                hashedPassword,
                saltString
        );

        User newUser = new User();
        newUser.setId(newId);
        newUser.setUsername(userName);

        return newUser;
    }

    /**
     * Look for a user with the given username and password. Since we don't
     * know the password, we will have to get the user's salt from the database,
     * hash the password, and compare that against the hash in the database.
     *
     * @param userName the username of the user we are checking
     * @param password the password of the user we are checking
     * @return true if the user is found and their password matches
     */
    @Override
    public boolean isUsernameAndPasswordValid(String userName, String password) {
        // because ILIKE not using '%', it just makes the userName case-insensitive
        String sqlSearchForUser = "SELECT * FROM users " +
                                  " WHERE username ILIKE '" + userName + "'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser);
        if (results.next()) {
            // get the salt & hashed password
            String storedSalt = results.getString("salt");
            String storedPassword = results.getString("password");
            // hash the input password
            String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
            // compare stored password hash with computed input hash
            return storedPassword.equals(hashedPassword);
        } else {
            return false;
        }
    }

    /**
     * Get all the users from the database.
     * @return a List of user objects
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sqlSelectAllUsers = "SELECT id, username FROM users";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);

        while (results.next()) {
            User user = new User();
            user.setId(results.getInt("id"));
            user.setUsername(results.getString("username"));
            users.add(user);
        }

        return users;
    }

}
