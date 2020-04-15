package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PhoneBook implements Serializable, Iterable<Contact> {
    private static final long serialVersionUID = 8419192590332967500L;

    private List<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    public boolean add(Contact contact) {
        return contacts.add(contact);
    }

    public boolean remove(Contact contact) {
        return contacts.remove(contact);
    }

    public Contact remove(int i) {
        return contacts.remove(i);
    }

    public Contact get(int i) {
        return contacts.get(i);
    }

    public Contact set(int i, Contact contact) {
        return contacts.set(i, contact);
    }

    public int size() {
        return contacts.size();
    }

    public boolean contains(Contact contact) {
        return contacts.contains(contact);
    }

    @Override
    public Iterator<Contact> iterator() {
        return contacts.iterator();
    }

    @Override
    public void forEach(Consumer<? super Contact> action) {
        contacts.forEach(action);
    }

    @Override
    public Spliterator<Contact> spliterator() {
        return contacts.spliterator();
    }
}
