package practice.javalang8.innerclasses;

public class AnonymousObjectClass {

    private final Object anonymObj = new Object() {

        @Override
        public boolean equals(final Object obj) {
            System.out.println("Nothing is equal");
            return false;
        }

        @Override
        public int hashCode() {
            System.out.println("what hashcode");
            return 0;
        }

        @Override
        public String toString() {
            System.out.println("To String");
            return "Anonymous Inner Object class";
        }
    };

    public static void main(final String[] args) {

        final AnonymousObjectClass obj = new AnonymousObjectClass();
        obj.anonymObj.hashCode();
        obj.equals("NOPE");
        obj.toString();
        obj.nonStaticMeth();
    }

    private void nonStaticMeth() {

        System.out.println("HELLO");
    }
}
