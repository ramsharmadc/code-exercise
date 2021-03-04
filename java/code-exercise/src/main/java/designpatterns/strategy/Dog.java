package designpatterns.strategy;

public abstract class Dog {

    EatBehaviour eatBehaviour;
    BarkBehaviour barkBehaviour;

    public Dog(){

    }

    abstract void display();

    public void doBark(){
        barkBehaviour.bark();
    }

    public void doEat(){
        eatBehaviour.eat();
    }

    public void setEatBehaviour(EatBehaviour eatBehaviour) {
        this.eatBehaviour = eatBehaviour;
    }

    public void setBarkBehaviour(BarkBehaviour barkBehaviour) {
        this.barkBehaviour = barkBehaviour;
    }
}
