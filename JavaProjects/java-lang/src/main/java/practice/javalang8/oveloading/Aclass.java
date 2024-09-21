package practice.javalang8.oveloading;

import java.util.List;

public class Aclass {

    public static void main(String[] args) {

        Aclass a = new Aclass();

    //    a.method(null, null); // COMPILE ERROR : ambiguous call

        // a.methodOne(null);
    }

    public static void sum(List<Integer> list) {

    }

    public String method(Integer i, String str) {

        System.out.println("returns string.");

        return "Return string";
    }

    public void method(String str, Object i) {

        System.out.println("Void method.");
    }

    public void methodOne(int[] arr) {

        System.out.println("In method one - int arr");
    }

    public void methodOne(Object object) {

    }

    public void methodOne(String[] str) {

        System.out.println("In method one - String arr");
    }

    // public static void sum(List<String> list) {} // uncomment and see

}
