package lang.jdk8.basics;

public class CheckVariableReference {

    public static void main(String[] args) {
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Crocodile");
        System.out.println("Before{a1:" + a1 + ", a2:" + a2 + "}");
        System.out.println("After{a1:" + a1 + ", a2:" + a2 + "}");
    }

    static void swap(Animal a1, Animal a2) {
        Animal temp = new Animal("");
        temp = a1;
        a1 = a2;
        a2 = temp;
    }

    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
