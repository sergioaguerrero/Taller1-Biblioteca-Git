package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // menu stage 8
        //createClient();
        //readClient();
        //readSearchClient();
        //deleteClient();

        //createBook();
        //readBook();
    }

    public static void createClient() {
        System.out.println("-----Create Client-----");

        System.out.print("Insert id: ");
        String id = sc.nextLine();
        System.out.print("Insert name: ");
        String name = sc.nextLine();
        System.out.print("Insert phone: ");
        String phone = sc.nextLine();
        System.out.print("Insert email: ");
        String email = sc.nextLine();

        Client client = new Client(email, id, name, phone);
        clients.add(client);
        System.out.println("Success");
    }

    public static void readClient() {
        if (clients.isEmpty()) {
            System.out.println("There are no registered clients.");
            return;
        }
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            System.out.println((i + 1) + " - " + client);
        }
    }

    public static void readSearchClient() {
        if (clients.isEmpty()) {
            System.out.println("There are no registered clients.");
            return;
        }
        System.out.println("Enter client ID");
        String idClient = sc.nextLine();

        int found = 0;
        for (Client client : clients) {
            if (client.getId().equals(idClient)) {
                System.out.println(client);
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("No client was found with ID: " + idClient);
        }
    }

    public static void updateClient() {
        if (clients.isEmpty()) {
            System.out.println("There are no registered clients.");
            return;
        }
        System.out.println("Enter client ID to update");
        String idClient = sc.nextLine();

        for (Client client : clients) {
            if (client.getId().equals(idClient)) {
                System.out.print("Insert new name: ");
                String name = sc.nextLine();
                System.out.print("Insert new phone: ");
                String phone = sc.nextLine();
                System.out.print("Insert new email: ");
                String email = sc.nextLine();
                client.setName(name);
                client.setPhone(phone);
                client.setEmail(email);

                System.out.println("Client updated successfully.");
                return;
            }
        }
        System.out.println("No client was found with ID: " + idClient);
    }

    public static void deleteClient() {
        if (clients.isEmpty()) {
            System.out.println("There are no registered clients.");
            return;
        }
        System.out.println("Enter client ID to update");
        String idClient = sc.nextLine();

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId().equals(idClient)) {
                clients.remove(i);
                break;
            }
        }
    }

    //METODOS CLASE LIBROS

    public static void createBook() {
        System.out.println("-----Register Book-----");

        System.out.print("Insert id book: ");
        String id = sc.nextLine();
        System.out.print("Insert title: ");
        String title = sc.nextLine();
        System.out.print("Insert publication date: ");
        String publicationDate = sc.nextLine();
        System.out.print("Insert author: ");
        String author = sc.nextLine();

        Book book = new Book(id, title, publicationDate, author);
        books.add(book);
        System.out.println("Success");
    }

    public static void readBook() {
        if (books.isEmpty()) {
            System.out.println("There are no registered books.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + " - " + book);
        }
    }
}
