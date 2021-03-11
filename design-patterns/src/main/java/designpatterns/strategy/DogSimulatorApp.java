package designpatterns.strategy;

public class DogSimulatorApp {

    public static void main(String[] args) {
        Dog labra = new LabradorDog();
        labra.doEat();
        labra.setEatBehaviour(new NormalEating());
        labra.doEat();
        labra.doBark();
    }
}
