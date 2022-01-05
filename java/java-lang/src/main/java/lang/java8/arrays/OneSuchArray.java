package lang.java8.arrays;

import java.util.Arrays;

public class OneSuchArray {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        int[] arrPrimInts = {};

        Object obj = arr;
        System.out.println(obj);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        Number[] numbers = arr;
        System.out.println("\n" + Arrays.toString(numbers));

        System.out.println("Class of Integer array is :: " + arr.getClass());
        System.out.println("Super Class of Integer array is :: " + arr.getClass().getSuperclass());

        System.out.println("Class of int array is :: " + arrPrimInts.getClass());
        System.out.println(
                "Super Class of int array is :: " + arrPrimInts.getClass().getSuperclass());

        System.out
                .println(arr.getClass().getSuperclass() == arrPrimInts.getClass().getSuperclass());

    }

}
