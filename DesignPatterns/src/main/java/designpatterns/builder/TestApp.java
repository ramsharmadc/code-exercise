package designpatterns.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestApp {

    private static final Function<List<Contact>, List<Contact>> addContact = t -> {
        System.out.println("applying add function");
        List<Contact> contacts = new ArrayList<>();
        t.parallelStream().forEach(x -> contacts.add(x));
        return contacts;
    };
    private static final Function<List<Contact>, List<Contact>> printFunc = t -> {
        System.out.println("applying print function");
        t.parallelStream().forEach(x -> System.out.println(x));
        return t;
    };

    public static void main(String[] args) {
        ContactBuilder contactBuilder = new ContactBuilder();
        Contact lewis = contactBuilder.setFirstName("Adam").setLastName("Lewis").buildContact();
        Contact pkalyan = contactBuilder.setFirstName("Konr").setLastName("Krons").buildContact();
        Contact stew = contactBuilder.setFirstName("Stew").setLastName("Throguh").buildContact();
        Contact kraut = contactBuilder.setFirstName("German").setLastName("Karaut").buildContact();

        List<Contact> contacts = new ArrayList<>();
        contacts.add(lewis);
        contacts.add(stew);
        contacts.add(kraut);
        contacts.add(pkalyan);

        addContact.andThen(printFunc).apply(contacts);
    }
}
