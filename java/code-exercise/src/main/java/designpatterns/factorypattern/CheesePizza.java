package designpatterns.factorypattern;

public class CheesePizza<T> implements Pizza<T> {

    private final CheesePizza<T> cheesePizza;

    public CheesePizza() {
        cheesePizza = new CheesePizza<T>();
    }

    @Override
    public void bake() {
        // return cheesePizza;
    }

    @Override
    public void box() {
        // cheesePizza = new CheesePizza<>();
    }

    @Override
    public void cut() {
        // cheesePizza = new CheesePizza<>();
    }

    @Override
    public Pizza<T> prepare() {
        return cheesePizza;
    }
}
