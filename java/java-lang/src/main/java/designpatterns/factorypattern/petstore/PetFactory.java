package designpatterns.factorypattern.petstore;

public class PetFactory {
    public static Pet createPet(String type, String name) {
        switch (type.toLowerCase()) {
            case "cat":
                return createCat(name);
            case "dog":
                return createDog(name);
            default:
                throw new RuntimeException("Not a valid pet");
        }
    }

    private static Pet createCat(String name) {
        return new Cat(name);
    }

    private static Pet createDog(String name) {
        return new Dog(name);
    }
}
