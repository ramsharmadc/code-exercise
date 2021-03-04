package designpatterns.factorypattern;

public class PizzaFactory {
    public Pizza<?> createPizza(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new CheesePizza();
        } else if (type.equalsIgnoreCase("greek")) {
            return new GreekPizza();
        } else if (type.equalsIgnoreCase("pepper")) {
            return new PepperPizza();
        }
        return null;
    }
}
