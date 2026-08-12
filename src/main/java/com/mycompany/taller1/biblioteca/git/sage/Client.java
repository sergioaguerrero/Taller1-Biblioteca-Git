package com.mycompany.taller1.biblioteca.git.sage;

public class Client extends Person {
    String email;

    public Client() {
    }

    public Client(String email, String id, String name, String phone) {
        super(id, name, phone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

