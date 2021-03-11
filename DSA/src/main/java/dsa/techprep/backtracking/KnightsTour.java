package dsa.techprep.backtracking;

public class KnightsTour {
    static int N = 8;

    static void initialize(int x, int y, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = -1;
            }
        }
    }

    static boolean isSafe(int x, int y, int[][] board) {
        return x >= 0 &&
                x < board.length &&
                y >= 0 &&
                y < board.length &&
                board[x][y] == -1;
    }

    static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solve() {
        int[][] sol = new int[N][N];
        initialize(N, N, sol);

        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        if (!solveKnightsTourTour(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;

    }

    static boolean solveKnightsTourTour(int x, int y, int movei,
                                        int sol[][], int xMove[],
                                        int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        /* Try all next moves from the current coordinate x, y */
        for (k = 0; k < 8; k++) {

            next_x = x + xMove[k];
            next_y = y + yMove[k];

            if (isSafe(next_x, next_y, sol)) {

                sol[next_x][next_y] = movei;

                if (solveKnightsTourTour(
                        next_x,
                        next_y,
                        movei + 1,
                        sol,
                        xMove,
                        yMove))
                    return true;
                else
                    sol[next_x][next_y]
                            = -1; // backtracking
            }
        }

        return false;
    }

    /* Driver Code */
    public static void main(String args[]) {
        // Function Call
        solve();
    }

}
