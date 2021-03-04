package dsa.algos.recursion;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] m = new int[4][4];
        // '0' means way and '1' means block
        m[0][0] = 0;
        m[0][1] = -1;
        m[0][2] = -1;
        m[0][3] = -1;
        m[1][0] = 0;
        m[1][1] = 0;
        m[1][2] = -1;
        m[1][3] = 0;
        m[2][0] = -1;
        m[2][1] = 0;
        m[2][2] = -1;
        m[2][3] = -1;
        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = 0;
        m[3][3] = 0;

        printSolution(m);
        System.out.println();

        // starting point m[0][0]
        boolean f = is_there_a_path(m, 0, 0);
        if (f)
            printSolution(m);
    }

    private static boolean is_there_a_path(int[][] m, int i, int j) {
        if (i == m.length - 1 && j == m[0].length - 1 && m[i][j] == 0) {
            m[i][j] = 1;
            return true;
        }

        // escaped base condition, move right and left
        if (is_safe_cell(m, i, j)) {
            m[i][j] = 1;
            if (is_there_a_path(m, i, j + 1))
                return true;
            if (is_there_a_path(m, i + 1, j))
                return true;
            return is_there_a_path(m, i + 1, j);
        }
        return false;
    }

    private static boolean is_safe_cell(int[][] m, int i, int j) {
        return i >= 0 && i < m.length && j >= 0 && j < m[0].length && m[i][j] == 0;
    }

    static void printSolution(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }
}
