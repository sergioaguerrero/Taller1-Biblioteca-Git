package com.mycompany.biblioteca;

public class Book extends Material{
    private String author;
    private boolean available;

    public Book() {
    }

    public Book(String idBook, String title, String publicationDate, String author) {
        super(idBook, title, publicationDate);
        this.author = author;
        this.available = true;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}
