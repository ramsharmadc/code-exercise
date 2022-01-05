package lang.java8.arrays;

public class ArrayReferences {


    public static void main(String[] args) {
        int[] a1 = {3, 4, 5};
        int[] a2 = modifyArray(a1);
        System.out.println(a1[0] + a1[1] + a1[2]);
        System.out.println(a2[0] + a2[1] + a2[2]);
    }

    private static int[] modifyArray(int[] a1) {
        a1[1] = 7;
        return a1;
    }
}
