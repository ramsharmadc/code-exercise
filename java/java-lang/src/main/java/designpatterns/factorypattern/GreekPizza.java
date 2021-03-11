package designpatterns.factorypattern;

public class GreekPizza implements Pizza {

    private GreekPizza greekPizza = null;

    public GreekPizza() {

        greekPizza = new GreekPizza();
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
        return greekPizza;

        // TODO Auto-generated method stub

    }
}
