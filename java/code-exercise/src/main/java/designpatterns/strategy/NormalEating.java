package designpatterns.strategy;

public class NormalEating implements EatBehaviour {

    @Override
    public void eat() {
        System.out.println("Taking normal diet");
    }
}
