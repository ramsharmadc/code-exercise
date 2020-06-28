package designpatterns.builder;

public class TestApp {

    public static void main(String[] args) {
        ContactBuilder contactBuilder = new ContactBuilder();
        Contact contact = contactBuilder.setFirstName("Adam").setLastName("Lewis").buildContact();
        System.out.println(contact);
    }
}
