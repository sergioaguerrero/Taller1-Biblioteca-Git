package com.mycompany.taller1.biblioteca.git.sage;

import java.util.ArrayList; 
import java.util.Scanner; 

public class Main {
    static ArrayList<Client> clients = new ArrayList<>(); 
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // menu stage 8
        createClient();
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
}
