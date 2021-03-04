package designpatterns.strategy;

public class GrowlBark implements BarkBehaviour{
    @Override
    public void bark() {
        System.out.println("Growling Bark");
    }
}
