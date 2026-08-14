package com.mycompany.biblioteca;

public class Material {
    private String idBook;
    private String title;
    private String publicationDate;

    public Material() {
    }

    public Material(String idBook, String title, String publicationDate) {
        this.idBook = idBook;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
