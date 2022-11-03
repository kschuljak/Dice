package com.techelevator;

import com.techelevator.models.Book;

public class BookProgram {

    public static void main(String[] args) {

        // creates new 'book' object from 'Book' class
        Book book = new Book();

        Book headFirstJava = new Book();

        // returning object variables that haven't been set yet - returns default values
        System.out.println("Title: " + headFirstJava.getTitle());   // null (default for reference data types)
        System.out.println("Number of pages: " + headFirstJava.getPages());   // 0 (default for numbers)

        // set variables for 'headFirstJava' object of 'Book' class
        headFirstJava.setTitle("Head First Java: A Brain-Friendly Guide: 3rd Edition");
        headFirstJava.setAuthor("Kathy Sierra");
        headFirstJava.setIsbn("1491910771");
        headFirstJava.setPages(250);
    }
}
