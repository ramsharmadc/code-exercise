package practice.javalang8.oveloading;

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
        Object anObject = new Object();
        String str  = new String("aString");
        callMe(str);
        callMe(anObject);
        callMe(null);
    }
}
