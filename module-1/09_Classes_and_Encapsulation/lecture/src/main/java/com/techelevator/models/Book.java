package com.techelevator.models;

public class Book {

    private String title;
    private String isbn;
    private String author;
    private int pages;

    // title - getter & setter
    // 'this' keyword refers to the current class/object that we are in
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    // isbn - getter & setter
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // author - getter & setter
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // pages - getter & setter
    public int getPages(){
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }


}
