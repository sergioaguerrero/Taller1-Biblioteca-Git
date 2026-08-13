package com.mycompany.taller1.biblioteca.git.sage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // menu stage 8
        //createClient();
        //readClient();
        //readSearchClient();
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
}
