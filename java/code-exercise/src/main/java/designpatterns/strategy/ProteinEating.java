package designpatterns.strategy;

public class ProteinEating implements EatBehaviour {

    @Override
    public void eat() {
        System.out.println("Taking protein diet");
    }
}
