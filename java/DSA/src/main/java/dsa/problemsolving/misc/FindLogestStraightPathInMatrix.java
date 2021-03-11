package dsa.problemsolving.misc;

public class FindLogestStraightPathInMatrix {

    public static void main(String[] args) {
        int maxPath = findMaxLength(new int[0][0]);
        System.out.println(maxPath);
    }

    public static int findMaxLength(int[][] a) {
        int currMax = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int max = getMaxPath(a, i, j);
                currMax = currMax < max ? max : currMax;
            }
        }
        return currMax;
    }

    public static int getMaxPath(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            int upwardRightDgnl = getupwardRightDgnl(a, i, j);
            int upwardLeftDgnl = getupwardLeftDgnl(a, i, j);
            int downwardLeftDgnl = getdownwardLeftDgnl(a, i, j);
            int downwardRightDgnl = getdownwardRightDgnl(a, i, j);
            int rightDirection = getrightDirection(a, i, j);
            int leftDirection = getleftDirection(a, i, j);
            int upwardDirection = getupwardDirection(a, i, j);
            int downwardDirection = getdownwardDirection(a, i, j);

            return Math.max(upwardRightDgnl, Math.max(upwardLeftDgnl, Math.max(downwardLeftDgnl,
                    Math.max(downwardRightDgnl, Math.max(rightDirection, Math.max(leftDirection,
                            Math.max(upwardDirection, downwardDirection)))))));
        }
    }

    private static int getupwardRightDgnl(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getupwardRightDgnl(a, i - 1, j + 1);
        }
    }

    private static int getupwardLeftDgnl(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getupwardLeftDgnl(a, i - 1, j + 1);
        }
    }

    private static int getdownwardLeftDgnl(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getdownwardLeftDgnl(a, i - 1, j + 1);
        }
    }

    private static int getdownwardRightDgnl(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getdownwardRightDgnl(a, i - 1, j + 1);
        }
    }

    private static int getrightDirection(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getrightDirection(a, i - 1, j + 1);
        }
    }

    private static int getleftDirection(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getleftDirection(a, i - 1, j + 1);
        }
    }

    private static int getupwardDirection(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getupwardDirection(a, i - 1, j + 1);
        }
    }

    private static int getdownwardDirection(int[][] a, int i, int j) {
        if (!isCellOn(a, i, j)) {
            return 0;
        } else {
            return 1 + getdownwardDirection(a, i - 1, j + 1);
        }
    }

    public static boolean isCellOn(int[][] a, int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length && a[i][j] == 1;
    }
}
