package practice.javalang8.arrays;

public class ArrayReferences {


    public static void main(String[] args) {
        int[] a1 = {3, 4, 5};
        System.out.println(a1[0] + a1[1] + a1[2]);
        int[] a2 = modifyArray(a1);
        System.out.println(a1[0] + a1[1] + a1[2]);
        System.out.println(a2[0] + a2[1] + a2[2]);
    }

    // the reference passed points to the original array object
    private static int[] modifyArray(int[] a1) {
        a1[1] = 7;
        return a1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
