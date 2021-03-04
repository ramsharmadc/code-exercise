package dsa.arrays;

public class FindIslandWithMax1 {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0}};

        boolean[][] visited = new boolean[][]{{false, false, false, false, false},
                {false, false, false, false, false}, {false, false, false, false, false},
                {false, false, false, false, false}, {false, false, false, false, false}};

        printMatrix(a, visited);
        int maxIsland = findMaxIslandDFS(a, a.length, a[0].length, visited);
        System.out.println(maxIsland);
    }

    private static void printMatrix(int[][] a, boolean[][] visited) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "(" + isSafeCell(a, i, j, visited) + ") ");
            }
            System.out.println();
        }
    }

    private static boolean isSafeCell(int[][] a, int m, int n, boolean[][] isVisited) {
        return m >= 0 && m < a.length && n >= 0 && n < a[0].length && a[m][n] == 1
                && !isVisited[m][n];
    }

    private static int findMaxIslandDFS(int[][] a, int m, int n, boolean[][] visited) {
        return 0;
    }

}
