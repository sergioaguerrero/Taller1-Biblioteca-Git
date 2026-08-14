package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private static int loanCounter = 1;

    public static void main(String[] args) {
        // menu stage 8
        //createClient();
        //readClient();
        //readSearchClient();
        //deleteClient();

        //createBook();
        //readBook();
        //readSearchBook();
        //updateBook();

        //createLoan(client, book)
    }

    //METHODS CLASS CLIENT

    public static void createClient() {
        System.out.println("-----Create Client-----");

        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
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
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new phone: ");
                String phone = sc.nextLine();
                System.out.print("Enter new email: ");
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

    //METHODS CLASS BOOK

    public static void createBook() {
        System.out.println("-----Register Book-----");

        System.out.print("Enter id book: ");
        String id = sc.nextLine();
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter publication date: ");
        String publicationDate = sc.nextLine();
        System.out.print("Enter author: ");
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

    public static void readSearchBook() {
        if (books.isEmpty()) {
            System.out.println("There are no registered books.");
            return;
        }
        System.out.println("Enter book ID");
        String idBook = sc.nextLine();

        int found = 0;
        for (Book book : books) {
            if (book.getIdBook().equals(idBook)) {
                System.out.println(book);
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("No books was found with ID: " + idBook);
        }
    }

    public static void updateBook() {
        if (books.isEmpty()) {
            System.out.println("There are no registered books.");
            return;
        }
        System.out.println("Enter book ID to update");
        String idBook = sc.nextLine();

        for (Book book : books) {
            if (book.getIdBook().equals(idBook)) {
                System.out.print("Enter new title: ");
                String title = sc.nextLine();
                System.out.print("Enter new publication date: ");
                String publicationDate = sc.nextLine();
                System.out.print("Enter new author: ");
                String author = sc.nextLine();

                book.setTitle(title);
                book.setPublicationDate(publicationDate);
                book.setAuthor(author);

                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("No book was found with ID: " + idBook);
    }

    public static void deleteBook() {
        if (books.isEmpty()) {
            System.out.println("There are no registered books.");
            return;
        }
        System.out.println("Enter book ID to delete");
        String idBook = sc.nextLine();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIdBook().equals(idBook)) {
                books.remove(i);
                break;
            }
        }
    }

    //METHODS CLASS LOAN

    public static void createLoan() {
        System.out.println("-----Register Loan-----");

        if (clients.isEmpty()) {
            System.out.println("There are no registered clients.");
            return;
        }
        if (books.isEmpty()) {
            System.out.println("There are no registered books.");
            return;
        }

        System.out.print("Enter client ID: ");
        String idClient = sc.nextLine();

        Client clientFound = null;

        for (Client client : clients) {
            if (client.getId().equals(idClient)) {
                clientFound = client;
                break;
            }
        }
        if (clientFound == null) {
            System.out.println("No client was found with ID: " + idClient);
            return;
        }

        System.out.print("Enter book ID: ");
        String idBook = sc.nextLine();

        Book bookFound = null;

        for (Book book : books) {
            if (book.getIdBook().equals(idBook)) {
                bookFound = book;
                break;
            }
        }
        if (bookFound == null) {
            System.out.println("No book was found with ID: " + idBook);
            return;
        }
        if (!bookFound.isAvailable()) {
            System.out.println("The book " + bookFound.getTitle() + " is not available.");
            return;
        }

        String idLoan = String.format("%04d", loanCounter);
        loanCounter++;

        LocalDate today = LocalDate.now();

        Loan newLoan = new Loan(
                idLoan,
                clientFound,
                bookFound,
                today,
                "Active"
        );

        bookFound.setAvailable(false);
        loans.add(newLoan);

        System.out.println("Loan registered successfully [ID: " + idLoan + "]");
    }



}
