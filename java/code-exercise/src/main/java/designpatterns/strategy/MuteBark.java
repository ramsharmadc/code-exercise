package designpatterns.strategy;

public class MuteBark implements BarkBehaviour{
    @Override
    public void bark() {
        System.out.println("Muted Bark");
    }
}
