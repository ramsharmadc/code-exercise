package designpatterns.builder;

public class UseBuilderPattern {

    private final int id;
    private final int age;
    private String fistame;

    public UseBuilderPattern(int id, int age) {
        this.id = id;
        this.age = age;
    }

    static class ObjectBuilder {

        private int id;
        private int age;

//        designpatterns.builder.UseBuilderPattern obj = new designpatterns.builder.UseBuilderPattern(id, age);

        public void addId(int id) {
            this.id = id;
        }

        public void addAge(int age) {
            this.age = age;
        }

        public UseBuilderPattern build() {
            System.out.println("Building object");
            UseBuilderPattern obj = new UseBuilderPattern(id, age);
            return obj;
        }
    }

}
