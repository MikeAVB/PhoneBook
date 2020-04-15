package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
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

    public int size() {
        return list.size();
    }

    public boolean contains(Contact contact) {
        return list.contains(contact);
    }
}
