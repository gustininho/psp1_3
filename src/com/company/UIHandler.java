package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import Lab2.impl.EmailValidator;

public class UIHandler {
    public static void showHomepage() {
        int input = 0;
        Scanner in = new Scanner(System.in);

        while (input!=5)
        {
            System.out.println("Iveskite, ka daryti toliau:");
            System.out.println();
            System.out.println("1: Prideti vartotoja");
            System.out.println("2: Parodyti vartotojo duomenis");
            System.out.println("3: Istrinti vartotoja pagal id");
            System.out.println("4: Pakeisti vartotojo el. pasta");
            System.out.println("5: Iseiti is programos");
            System.out.println("--------------------------------");

            input = in.nextInt();

            switch(input) {
                case 1:
                    showAddUserDialogue();
                    break;
                case 2:
                    showUserData();
                    break;
                case 3:
                    showDeleteUser();
                    break;
                case 4:
                    showEditEmailDialogue();
                    break;
            }
        }
    }

    public static void showAddUserDialogue() {
        try{
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Iveskite varda");
            String firstName = reader.readLine();
            System.out.println("Iveskite pavarde");
            String lastName = reader.readLine();
            System.out.println("Iveskite telefono numeri be prefixo");
            String number = reader.readLine();
            System.out.println("Iveskite emaila");
            String email = reader.readLine();
            System.out.println("Iveskite adresa");
            String adress = reader.readLine();
            System.out.println("Iveskite slaptazodi");
            String password = reader.readLine();
            User user = new User(firstName, lastName, number, email, adress, password);

            if (ValidationHandler.isUserInfoValid(user)) {
                ConnectionHandler.insertUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getId(){
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite savo user ID");
        int id = in.nextInt();

        return id;
    }

    public static void showUserData(){
        int id = getId();

        ConnectionHandler.selectUser(id);
    }

    public static void showDeleteUser(){
        int id = getId();

        ConnectionHandler.deleteUser(id);
    }

    public static void showEditEmailDialogue() {
        int id = getId();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        EmailValidator emVal = new EmailValidator();

        System.out.println("Iveskite nauja el. pasta");
        try {
            String email = reader.readLine();

            if (ValidationHandler.isEmailValid(email)){
                ConnectionHandler.editEmail(id,email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

