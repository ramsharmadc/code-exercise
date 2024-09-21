package dsa.datastructures.tries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneBookContacts {
    // Implement a phone contactsbook like system with the following features:
// 1. Add a contact (name, email, phNbr, wrkNbr)
// 2. Search contacts by name -> returns multiple results matching the search prefix.  Eg: "ra" -> ["ram", "ram sharma"] (show name first, and then entire contact on click event)
// 3. Delete a contact by name ( delete by a complete name, if not found no delete)

//(r) -> (a) -> (m)(contact)

    //          (r) -> (a) -> (m) -> (s) -> (h) -> (a) -> (r) -> (m) -> (a)(Contact)

// Note: A contact can have name, email, phonenumber, work number

    private Node root;

    public boolean add(Contact contact) {
        root = new Node();

        return add(contact);
    }

    private boolean add(String name, String email, String phoneNUmber, String workNumber) {

        Node ptr = root;
        Contact c = new Contact(name, email, phoneNUmber, workNumber);

        for (int i = 0; i < name.length(); i++) {

            Node next = ptr.getChild().get(name.charAt(i));

            if (next == null) {
                next = new Node();
                root.getChild().put(name.charAt(i), next);
                root.setContact(c);
            }

            ptr = next;

            if (i == name.length() - 1) {
                ptr.setLeaf(true);
            }
        }

        return true;
    }

    private Set<String> search(Node cur, String prefix, Set<String> allContacts) {

        if (cur.isLeaf()) allContacts.add(cur.getContact().getName());

        for (char i = 'a'; i <= 'z'; i++) {
            Node nxt = cur.getChild().get(i);
            if (nxt != null) {
                search(nxt, prefix + i, allContacts);
            }
        }

        return allContacts;
    }

    public Set<String> search(String input) {

        Set<String> matchingNodes = new HashSet<>();
        Node cur = root;
        int len = input.length();
        String prefix = "";

        Set<String> matchingContacts = new HashSet<>();

        for (int i = 0; i < len; i++) {
            prefix += input.charAt(i);

            char lastEnteredChar = prefix.charAt(i);

            Node nxt = cur.getChild().get(lastEnteredChar);

            if (nxt == null) {
                return matchingContacts;
            }

            matchingNodes = search(nxt, prefix, matchingContacts);

            cur = nxt;
        }

        for (String n : matchingNodes) {
            matchingContacts.add(n);
        }

        return matchingContacts;
    }
}

class Node {

    private HashMap<Character, Node> child;
    private Contact contact;
    boolean isLeaf;

    public Node() {
        child = new HashMap<>();

        for (char i = 'a'; i <= 'z'; i++) {
            child.put(i, null);
            contact = null;
        }

        isLeaf = false;
    }

    // getter, setter


    public HashMap<Character, Node> getChild() {
        return child;
    }

    public void setChild(HashMap<Character, Node> child) {
        this.child = child;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}

class Contact {

    public Contact(String name, String email, String phoneNumber, String workNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.workNumber = workNumber;
    }

    private String name;
    private String email;
    private String phoneNumber;
    private String workNumber;

    // getter , setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
}


