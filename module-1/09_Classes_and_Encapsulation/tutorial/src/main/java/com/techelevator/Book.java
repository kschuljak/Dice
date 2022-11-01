package com.techelevator;

public class Book {

    // adds private instance variables
    private String title;
    private String author;
    private double price;

    // creates public getter for the title instance variable
    public String getTitle() {
        return title;
    }

    // creates public setter for the title instance variable
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void printBook() {
        System.out.println(" TITLE: " + this.title);
        System.out.println("AUTHOR: " + this.author);
        System.out.println(" PRICE: " + this.price);
        System.out.println();
    }

    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Price: $" + price;
    }

    // default constructor
    public Book() {

    }
    // creates a constructor with title, author, and price as arguments
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

}
