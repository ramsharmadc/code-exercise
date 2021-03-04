package dsa.algos;

public class FindAllSubsets {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6}; // should give (1), (), (2), (1,2)
        int[] subset = new int[a.length];

        allSubsets(a, subset, 0);
    }

    private static void allSubsets(int[] a, int[] subset, int l) {

        if (l == a.length)
            printNonZero(subset);
        else {
            subset[l] = 0;
            allSubsets(a, subset, l + 1);
            subset[l] = a[l];
            allSubsets(a, subset, l + 1);
        }
    }

    private static void printNonZero(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                System.out.print(a[i]);
                if (i < a.length - 1)
                    System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
