package dsalgo.algos.recursion;

public class MaximumConnectedRegion {

    private static int count = 0;

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1}, {0, 1}};
        int maxRegion = findMaxRegion(0, 0, a);
        System.out.println(maxRegion);
    }

    private static int findMaxRegion(int i, int j, int[][] a) {
        for (int m = 0; m < a.length; m++) {
            if (a[i][j] == 1)
                count++;
            findMaxRegion(m + 1, m, a);
            findMaxRegion(m, m + 1, a);
            findMaxRegion(m, m - 1, a);
        }
        return count;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

}
