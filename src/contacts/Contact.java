package contacts;

import java.util.Objects;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String number;

    private Pattern pattern;

    {
        pattern = Pattern.compile("[+]?\\d{0,10}");
    }

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
        this.surname = "";
        this.number = "";
    }

    public Contact(String name, String number) {
        this.name = name;
        this.setNumber(number);
        this.surname = "";
    }

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (isValidNumber(number)) {
            this.number = number;
        } else {
            throw new RuntimeException("Invalid number: " + number);
        }
    }

    public boolean hasNumber() {
        return !number.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                surname.equals(contact.surname) &&
                number.equals(contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, number);
    }

    private boolean isValidNumber(String input) {
        return pattern.matcher(input).matches();
    }
}
