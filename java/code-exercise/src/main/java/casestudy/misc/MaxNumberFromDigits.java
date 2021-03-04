package casestudy.misc;

/**
 * Given a Integer, find the maximum number that can be formed from the digits. Input : 8754365
 * output : 8765543
 */
public class MaxNumberFromDigits {

    public static void main(String[] args) throws Exception {
        findMaxNumberFrom(8754365);
        findMaxNumberFrom(4265498);
        findMaxNumberFrom(77962378);
        findMaxNumberFrom(9898);
    }

    static int findMaxNumberFrom(int n) {
        int[] a = new int[10];
//        System.out.println(n);

        while (n != 0) {
            int m = n % 10;
            n = n / 10;
            a[9 - m] = a[9 - m] + 1;
        }

        for (int g = 0; g < a.length; g++) {
            if (a[g] != 0) {
                for (int l = 0; l < a[g]; l++) {
                    System.out.print(9 - g);
                }
            }
        }
        System.out.println();
        return 0;
    }
}
