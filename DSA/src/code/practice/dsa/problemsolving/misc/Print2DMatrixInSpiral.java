package dsa.problemsolving.misc;

public class Print2DMatrixInSpiral {

    public static void main(String[] args) {
        int[][] a =
                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        printMatrixInSpiral(a, a.length, a[0].length);
    }

    public static void printMatrixInSpiral(int[][] a, int n, int m) {
        int[] result = new int[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    Coordinates c = getRightCoordinates(i, j);
                }
            }
        }

    }

    public static
    boolean isSafe(int[][] a, int n, int m) {
        return n < a.length && n >= 0 && m < a[0].length && m >= 0;
    }

    public static
    Coordinates getLeftCoordinates(int n, int m) {
        return new Coordinates(n, m - 1);
    }

    public static
    Coordinates getRightCoordinates(int n, int m) {
        return new Coordinates(n, m + 1);
    }

    public static
    Coordinates getUpCoordinates(int n, int m) {
        return new Coordinates(n - 1, m);
    }

    public static
    Coordinates getDownCoordinates(int n, int m) {
        return new Coordinates(n + 1, m);
    }

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
