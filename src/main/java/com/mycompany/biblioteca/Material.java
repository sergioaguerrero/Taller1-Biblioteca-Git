package com.mycompany.biblioteca;

public class Material {
    private String idBook;
    private String title;
    private String anioPublic;

    public Material() {
    }

    public Material(String idBook, String title, String anioPublic) {
        this.idBook = idBook;
        this.title = title;
        this.anioPublic = anioPublic;
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

    public String getAnioPublic() {
        return anioPublic;
    }

    public void setAnioPublic(String anioPublic) {
        this.anioPublic = anioPublic;
    }
}
