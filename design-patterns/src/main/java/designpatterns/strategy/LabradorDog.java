package designpatterns.strategy;

public class LabradorDog extends Dog {

    public LabradorDog() {
        barkBehaviour = new PlayfulBark();
        eatBehaviour = new ProteinEating();
    }

    @Override
    void display() {
        System.out.println("Display Labrador");
    }

    public void doBark() {
        barkBehaviour.bark();
    }

    public void doEat() {
        eatBehaviour.eat();
    }
}
