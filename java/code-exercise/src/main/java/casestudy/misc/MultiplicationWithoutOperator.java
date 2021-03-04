package casestudy.misc;

public class MultiplicationWithoutOperator {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int n = 13; // this is the number
        int m = 13; // this is the multiplier

        System.out.println(multiply(n, m));
    }

    public static int multiply(int n, int m) {

        int temp = n;
        for (int i = 0; i < (m - 1); i++) {
            for (int j = 0; j < n; j++) {
                temp++;
            }
        }

        return temp;
    }
}
