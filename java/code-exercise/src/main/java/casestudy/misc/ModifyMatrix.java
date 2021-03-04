package casestudy.misc;

public class ModifyMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 3}, {5, 7}};
        int[][] b = new int[a.length][a[0].length];
        modifyMatrix(a, b);

        printMatrix(a);
        printMatrix(b);

//        System.out.println(a);
//        System.out.println(b);
    }

    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void modifyMatrix(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                calculateCell(a, b, i, j);
            }
        }
    }

    private static void calculateCell(int[][] a, int[][] b, int x, int y) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                sum += a[i][j];
            }
        }
        b[x][y] = sum;
    }
}
