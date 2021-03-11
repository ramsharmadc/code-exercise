package dsa.algorithms.recursion;

public class SimpleRecursion {

    public static void main(String[] args) {
        SimpleRecursion sr = new SimpleRecursion();
        sr.simpleRec(1000);
    }

    private int simpleRec(int i) {
        if (i == 0) {
            System.out.format("returning %d \n", i);
            return i;
        }
        int newC = simpleRec(i - 1);
        System.out.println(newC);
        System.out.format("returning %d \n", i);
        return i;
    }
}
