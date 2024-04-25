package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static int numBooks = 5;

    public static String name = "";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "";


        Book[] books = new Book[5];

        int numBooks = 5;

        books[0] = new Book(111, "B1", "The Cat in the Hat", false, "");
        books[1] = new Book(222, "B2", "Diary of a Whimpy Kid", false, "");
        books[2] = new Book(333, "B3", "Harry Potter and the Sorcerer's Stone", false, "");
        books[3] = new Book(444, "B4", "Captain Underpants", false, "");
        books[4] = new Book(555, "B5", "Green Eggs and Ham", false, "");

        int command = 0;

        while (command != 3) {
            System.out.println("Chose one option: \n1: Show Available Books\n2: Show Checked Out Books\n3: Exit");
            System.out.println("Enter your command: ");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    showAvailableBooks(scanner, books);
                    break;
                case 2:
                    showCheckedOutBooks(scanner, books);
                    break;
                case 3:
                    System.out.println("Exciting...");
                    break;
                default:
                    System.out.println("Invalid Command");
            }


        }


    }

    private static void showCheckedOutBooks(Scanner scanner, Book[] books) {
        for (Book book : books)
            if ((book.isCheckedOut())) {
                System.out.println("===============================");
                System.out.println("ID: " + book.getId());
                System.out.println("ISBN: " + book.getId());
                System.out.println("Title: " + book.getId());
                System.out.println("Checked out by: " + book.getId());
                System.out.println();
                System.out.println("C - to Check in a Book: " + book.getId());
                System.out.println("X - to go back to the home screen: " + book.getId());
            }
        System.out.println("C - to check in a book");
        System.out.println("X -  to exit");
        System.out.println("Enter your command: ");
        String input = scanner.next();
        if (input.equals("C") || input.equals("c")) {
            checkInBook(scanner,books);
        } else if (input.equals("X") || input.equals("x")) {
            //display homescreen
        } else {
            System.out.println("Invalid command");
        }

    }


    public static void showAvailableBooks(Scanner scanner, Book[] books) {
        while (true) {

            for (Book book : books)
                if (!(book.isCheckedOut())) {
                    System.out.println("ID: " + book.getId() + " ISBN: " + book.getIsbn() + " Title: " + book.getTitle());

                }
            System.out.println("\n\n");
            System.out.println("O - to Check Out a Book");
            System.out.println("X - to return to the home screen");

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("O")) {
                checkOutBook(scanner, books);
            } else if (input.equals("X")) {
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }


    public static void checkOutBook(Scanner scanner, Book[] books) {
        System.out.println("Enter Book's ID: ");
        int chosenBook = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == chosenBook && !book.isCheckedOut()) {
                System.out.println("Enter your name: ");
                String name1 = scanner.nextLine();
                book.checkOut(name1);
                //display homescreen

            } else {
                System.out.println("Invalid book and/or book is already checked out");
            }

        }


    }

    public static void checkInBook(Scanner scanner, Book[] books) {
        System.out.println("Enter Book's ID: ");
        int chosenBook = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == chosenBook && book.isCheckedOut()) {
                book.checkIn();
                //display homescreen
            } else {
                System.out.println("invalid book and/or the book is checked in");
            }
        }


    }


}