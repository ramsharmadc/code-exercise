package casestudy.topkcustomers;

import java.util.*;

public class TestCustomerProducts {

    private final static Comparator<Customer> customerComparator = TestCustomerProducts::compare;
    private static final Queue<Customer> orderedCustomers = new PriorityQueue<>(customerComparator);

    public static void main(String[] args) {

        Product product1 = new Product(1, "~P1");
        Product product2 = new Product(2, "~P2");
        Product product3 = new Product(3, "~P3");
        Product product4 = new Product(4, "~P4");
        Product product5 = new Product(5, "~P5");
        Product product6 = new Product(6, "~P6");

        Customer c1 = new Customer(1);
        c1.getProducts().add(product1);
        c1.getProducts().add(product2);
        c1.getProducts().add(product3);
        c1.getProducts().add(product4);
        c1.getProducts().add(product5);

        Customer c2 = new Customer(2);
        c2.getProducts().add(product4);
        c2.getProducts().add(product5);

        Customer c3 = new Customer(3);
        c3.getProducts().add(product4);
        c3.getProducts().add(product5);
        c3.getProducts().add(product6);
        c3.getProducts().add(product1);

        orderedCustomers.add(c1);
        orderedCustomers.add(c2);
        orderedCustomers.add(c3);

        List<Customer> top2 = getTopCustomer(2);
        System.out.println(top2);
    }

    public static List<Customer> getTopCustomer(int n) {
        List<Customer> returnList = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            returnList.add(orderedCustomers.poll());
        }
        return returnList;
    }

    private static int compare(Customer o1, Customer o2) {
        return Integer.compare(o2.getProductCount(), o1.getProductCount());
    }
}
