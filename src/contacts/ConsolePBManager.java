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
        if (book.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            this.list();
            System.out.println("Select a record:");
            int recordIndex = Integer.parseInt(scanner.nextLine()) - 1;
            book.remove(recordIndex);
            System.out.println("The record removed!");
        }
    }

    @Override
    public void editContact() {
        if (book.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            this.list();
            System.out.println("Select a record:");
            int recordIndex = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.println("Select a field (name, surname, number):");
            String field = scanner.nextLine();
            Contact contact = book.get(recordIndex);
            switch (field) {
                case "name":
                    System.out.println("Enter name:");
                    contact.setName(scanner.nextLine());
                    break;
                case "surname":
                    System.out.println("Enter surname:");
                    contact.setSurname(scanner.nextLine());
                    break;
                case "number":
                    System.out.println("Enter number:");
                    try {
                        contact.setNumber(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        contact.setNumber("");
                    }
                    break;
                default:
                    System.out.println("Unknown field!");
            }
            System.out.println("The record updated!");
        }
    }

    @Override
    public void count() {
        System.out.printf("The Phone Book has %d records.\n", book.size());
    }

    @Override
    public void list() {
        for (int i = 0; i < book.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, book.get(i));
        }
    }
}
