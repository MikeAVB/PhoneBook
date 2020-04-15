package contacts;

import java.util.Scanner;

public class ConsolePBManager implements PhoneBookManager {
    private PhoneBook book;
    private Scanner scanner;

    public ConsolePBManager(PhoneBook book, Scanner scanner) {
        this.book = book;
        this.scanner = scanner;
    }

    @Override
    public void addContact() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        Contact.Builder builder = new Contact.Builder();
        try {
            builder.setName(name).setSurname(surname).setNumber(number);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The record added.");
        book.add(builder.build());
    }

    @Override
    public void removeContact() {

    }

    @Override
    public void editContact() {

    }

    @Override
    public void count() {

    }

    @Override
    public void list() {

    }
}
