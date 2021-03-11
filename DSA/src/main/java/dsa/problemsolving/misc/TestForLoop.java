package dsa.problemsolving.misc;

public class TestForLoop {

    public static void main(String[] args) {

        int i;
        for (i = 0; i < 10; i = i + 1) {
            System.out.println(i);
            break;
        }

        System.out.println(i);
    }
}
