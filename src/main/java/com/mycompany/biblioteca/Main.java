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
        String choice = "";
        do {
            System.out.println("""
            --- WELCOME TO THE LIBRARY HUB ---
            
            Enter option between 0 - 13
            
            -------- CLIENTS --------
            
            0. To create a new Client
            1. To list the Clients
            2. To search a Client
            3. To update a Client
            4. To delete a Client
            
            -------- BOOKS --------
            
            5. To create a new Book
            6. To list the Books
            7. To search a Book
            8. To update a Book
            9. To delete a Book
            
            -------- LOANS --------
            
            10. To create a new Loan
            11. To return a Loan
            12. To list the Loans
            
            13. To exit
            """);

            try {
                int menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 0: createClient();     break;
                    case 1: readClient();       break;
                    case 2: readSearchClient(); break;
                    case 3: updateClient();     break;
                    case 4: deleteClient();     break;

                    case 5: createBook();       break;
                    case 6: readBook();         break;
                    case 7: readSearchBook();   break;
                    case 8: updateBook();       break;
                    case 9: deleteBook();       break;

                    case 10: createLoan();      break;
                    case 11: returnLoan();      break;
                    case 12: readLoan();        break;

                    case 13: choice = "N";      break;

                    default: System.out.println("INVALID OPTION!!!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
            
            if (!choice.equalsIgnoreCase("N")) {
                System.out.print("\nDo you want to continue? (S/N): ");
                choice = sc.nextLine();
            }

        } while (choice.equalsIgnoreCase("S"));

        System.out.println("\nThank you for using Library Hub. Goodbye!");
    }

    //METHODS CLASS CLIENT

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

    public static void returnLoan() {
        System.out.println("-----Return Loan-----");

        if (loans.isEmpty()) {
            System.out.println("There are no registered loans.");
            return;
        }
        System.out.print("Enter loan ID: ");
        String idLoan = sc.nextLine();

        for (Loan loan : loans) {
            if (loan.getIdLoan().equals(idLoan)) {

                if (loan.getStatus().equals("Returned")) {
                    System.out.println("This loan has already been returned.");
                    return;
                }
                loan.setStatus("Returned");
                loan.getBook().setAvailable(true);

                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Loan not found.");
    }

    public static void readLoan() {
        if (loans.isEmpty()) {
            System.out.println("There are no registered loans.");
            return;
        }
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);
            System.out.println((i + 1) + " - " + loan);
        }
    }
}
