package dsa.algos.dynamicprogramming;

public class LCS implements DynamicProgramming {
    char[] X;
    char[] Y;
    StringBuilder _seq;

    public LCS() {
        _seq = new StringBuilder();
    }

    public LCS(final char[] _x, final char[] _y) {
        this();
        X = _x;
        Y = _y;
    }

    public String getLCS() {
        final int[][] B = LCSLength(X, Y);
        printLcs(B, X, (X.length - 1), (Y.length - 1));
        return _seq.toString();
    }

    private int[][] LCSLength(final char[] X, final char[] Y) {
        final int m = X.length;
        final int n = Y.length;
        final int[][] C = new int[m][n];
        final int[][] B = new int[m][n];

        for (int i = 0; i < m; i++) {
            C[i][0] = 0;
        }

        for (int j = 0; j < n; j++) {
            C[1][j] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X[i] == Y[j]) {
                    C[i][j] = 1 + C[i - 1][j - 1];
                    B[i][j] = 1;
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    B[i][j] = 2;
                } else {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = 3;
                }
            }
        }
        return B;
    }

    private void printLcs(final int[][] B, final char[] X, final int i, final int j) {
        if ((i == 0) || (j == 0))
            return;

        if (B[i][j] == 1) {
            printLcs(B, X, i - 1, j - 1);
            // System.out.print( X[i] ) ;
            _seq.append(X[i]);
        } else if (B[i][j] == 2) {
            printLcs(B, X, i - 1, j);
        } else {
            printLcs(B, X, i, j - 1);
        }
    }
}
