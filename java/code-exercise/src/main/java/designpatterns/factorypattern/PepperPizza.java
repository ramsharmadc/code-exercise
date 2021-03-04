package designpatterns.factorypattern;

public class PepperPizza implements Pizza {

    private PepperPizza pepperPizza = null;

    public PepperPizza() {

        pepperPizza = new PepperPizza();
    }

    @Override
    public void bake() {

        // TODO Auto-generated method stub

    }

    @Override
    public void box() {

        // TODO Auto-generated method stub

    }

    @Override
    public void cut() {

        // TODO Auto-generated method stub

    }

    @Override
    public Pizza prepare() {
        return pepperPizza;

        // TODO Auto-generated method stub

    }

}
