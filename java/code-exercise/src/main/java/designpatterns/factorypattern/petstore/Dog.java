package designpatterns.factorypattern.petstore;

public class Dog implements Pet {

    private String name;
    private String type;

    public Dog(String name) {
        this.name = name;
        this.type = "Dog";
    }

    @Override
    public void feed() {
        System.out.println("feeding " + type + " " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }
}
