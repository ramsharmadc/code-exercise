package designpatterns.factorypattern.petstore;

public class PetStoreApp {

    public static void main(String[] args) {

        Pet p1 = PetFactory.createPet("dog", "Adam");
        Pet p2 = PetFactory.createPet("Cat", "Adina");

        p1.feed();
        p2.feed();
    }
}
