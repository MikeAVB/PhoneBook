package contacts;

import java.io.Serializable;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Contact implements Serializable {
    private static final long serialVersionUID = -7304663980751235281L;

    //TODO: implement real phone number format pattern
    private final static String NUMBER_REGEX =
            "^\\+?(([a-zA-Z0-9]+)|(\\([a-zA-Z0-9]+\\))|([a-zA-Z0-9]+[ -]\\([a-zA-Z0-9]{2,}\\)))([ -][a-zA-Z0-9]{2,})*$";
    private final static Pattern pattern = Pattern.compile(NUMBER_REGEX);

    private final static String DEFAULT_NAME = "";
    private final static String DEFAULT_SURNAME = "";
    private final static String DEFAULT_NUMBER = "";

    private String name;
    private String surname;
    private String number;

    private Contact() {
        this.name = DEFAULT_NAME;
        this.surname = DEFAULT_SURNAME;
        this.number = DEFAULT_NUMBER;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.setNumber(number);
        this.surname = DEFAULT_SURNAME;
    }

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.setNumber(number);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(String number) {
        if (number.isEmpty() || pattern.matcher(number).matches()) {
            this.number = number;
        } else {
            throw new NumberFormatException("Wrong number format!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!name.equals(contact.name)) return false;
        if (!surname.equals(contact.surname)) return false;
        return number.equals(contact.number);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        if (!this.surname.isEmpty()) {
            builder.append(" ").append(this.surname);
        }
        builder.append(", ");
        if (!this.number.isEmpty()) {
            builder.append(this.number);
        } else {
            builder.append("[no number]");
        }
        return builder.toString();
    }

    public static class Builder {
        private Contact contact;

        public Builder() {
            this.contact = new Contact();
        }

        public Builder setName(String name) {
            this.contact.setName(name);
            return this;
        }

        public Builder setSurname(String surname) {
            this.contact.setSurname(surname);
            return this;
        }

        public Builder setNumber(String number) {
            this.contact.setNumber(number);
            return this;
        }

        public Contact build() {
            return contact;
        }
    }
}
