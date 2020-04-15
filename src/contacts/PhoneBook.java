package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PhoneBook implements Serializable, Iterable<Contact> {
    private static final long serialVersionUID = 8419192590332967500L;

    private List<Contact> list;

    public PhoneBook() {
        this.list = new ArrayList<>();
    }

    public boolean add(Contact contact) {
        return list.add(contact);
    }

    public boolean remove(Contact contact) {
        return list.remove(contact);
    }

    public Contact remove(int i) {
        return list.remove(i);
    }

    public Contact get(int i) {
        return list.get(i);
    }

    public Contact set(int i, Contact contact) {
        return list.set(i, contact);
    }

    public int size() {
        return list.size();
    }

    public boolean contains(Contact contact) {
        return list.contains(contact);
    }

    @Override
    public Iterator<Contact> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super Contact> action) {
        list.forEach(action);
    }

    @Override
    public Spliterator<Contact> spliterator() {
        return list.spliterator();
    }
}
