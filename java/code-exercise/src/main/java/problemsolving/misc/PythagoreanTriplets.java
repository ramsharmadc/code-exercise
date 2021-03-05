package problemsolving.misc;

public class PythagoreanTriplets {

    public static void findPythagoreanTriples(int[] a) {

        // int[][] newArr = new int[3][3];

        // replicate the original array with squared values, but this is real
        // bad idea

        // int[] squaredArray = new int[a.length];

        // for(int i = 0; i < a.length; i++)
        // squaredArray[i] = (a[i] * a[i]);

        for (int j = 0; j < a.length; j++)
            for (int k = j + 1; k < a.length; k++) {
                for (int l = k; l < a.length; l++) {
                    if (a[j] * a[j] + a[k] * a[k] == a[l] * a[l]) {
                        System.out.println("[" + a[j] + ", " + a[k] + ", " + a[l] + "]");
                        break;
                    }
                }
            }
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        findPythagoreanTriples(arr);
    }
}
