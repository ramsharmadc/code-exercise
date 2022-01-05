package lang.java8.arrays;

import java.util.Arrays;

public class CloningOfArray {

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = a.clone();

        System.out.println(a);
        System.out.println(b);
        System.out.println(Arrays.toString(b));
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
