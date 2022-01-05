package lang.java8.oveloading;

public class PassNullObject {

    public PassNullObject() throws Exception {

    }

    public static void callMe(final Object obj) {
        System.out.println("Object passed.");
    }

    public static void callMe(final String str) {
        System.out.println("String {" + str + "} passed.");
    }

    public static void main(final String[] args) {
        callMe("aString");
        callMe(new Object());
        callMe(null);
    }
}
