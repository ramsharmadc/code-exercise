package casestudy.topkcustomers;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private final Set<Product> products;
    private Integer id;

    public Customer(Integer id) {
        this.id = id;
        products = new HashSet<>(20);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public int getProductCount() {
        return products.size();
    }

    @Override
    public String toString() {
        return "Customer-" + id;
    }
}
