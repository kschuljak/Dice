package com.techelevator;

import com.techelevator.models.Book;

public class BooksProgram
{
    public static void main(String[] args)
    {
        Book headFirstJava = new Book();

        headFirstJava.setTitle("Head First Java: A Brain-Friendly Guide: 3rd Edition");
        headFirstJava.setAuthor("Kathy Sierra");
        headFirstJava.setIsbn("1491910771");
        headFirstJava.setPages(250);

        System.out.println("Title: " + headFirstJava.getTitle());
        System.out.println("Number of Pages: " + headFirstJava.getPages());
        System.out.println("Author: " + headFirstJava.getAuthor());
        System.out.println("ISBN: " + headFirstJava.getIsbn());
    }
}
