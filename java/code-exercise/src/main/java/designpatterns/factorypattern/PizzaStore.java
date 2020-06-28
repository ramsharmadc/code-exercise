package designpatterns.factorypattern;

public class PizzaStore {

	private final PizzaFactory factory;
	private Pizza<Integer> pizza = null;

	public PizzaStore(final PizzaFactory factory) {
		this.factory = factory;
	}

	public Pizza orderPizza(final String type) {
		pizza = (Pizza<Integer>) factory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	public Pizza OrderPizza2(final String type) {
		final Pizza pizza = factory.createPizza(type); // asking factory to
														// create objects
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
