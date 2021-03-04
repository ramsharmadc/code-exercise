package casestudy.misc;

public class CheckArrayContent {

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 8, 4, 7, 6};
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1])
                System.out.println("BREAK");
        }
    }
}
