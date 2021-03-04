package designpatterns.strategy;

public class PlayfulBark implements BarkBehaviour{
    @Override
    public void bark() {
        System.out.println("Playful Bark");
    }
}
