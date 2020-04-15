package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookManager manager = new ConsolePBManager(phoneBook, scanner);
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            String action = scanner.nextLine().trim().toLowerCase();
            switch (action) {
                case "add":
                    manager.addContact();
                    break;
                case "remove":
                    manager.removeContact();
                    break;
                case "edit":
                    manager.editContact();
                    break;
                case "count":
                    manager.count();
                    break;
                case "list":
                    manager.list();
                case "exit":
                    quit = true;
                    break;
                default:
                    System.out.printf("Unknown action \"%s\". Try again...\n", action);
            }
        }
        scanner.close();
    }
}