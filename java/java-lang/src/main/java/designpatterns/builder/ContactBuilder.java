package designpatterns.builder;

public class ContactBuilder {

    private String firstName;
    private String lastName;

    public ContactBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact buildContact() {
        return new Contact(firstName, lastName);
    }
}
