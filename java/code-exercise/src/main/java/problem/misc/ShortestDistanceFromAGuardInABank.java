package problem.misc;

import problem.util.CommonUtils;

public class ShortestDistanceFromAGuardInABank {

	/*
	 * Given a matrix that is filled with �O�, �G�, and �W� where
	 * �O� represents open space, �G� represents guards and �W�
	 * represents walls in a Bank. Replace all of the O�s in the matrix with their
	 * shortest distance from a guard, without being able to go through any walls.
	 * Also, replace the guards with 0 and walls with -1 in output matrix.
	 * 
	 * Expected Time complexity is O(MN) for a M x N matrix.
	 */

	// Examples:

	// O ==> Open Space
	// G ==> Guard
	// W ==> Wall

	// Input:
	// O O O O G
	// O W W O O
	// O O O W O
	// G W W W O
	// O O O O G

	// Output:
	// 3 3 2 1 0
	// 2 -1 -1 2 1
	// 1 2 3 -1 2
	// 0 -1 -1 -1 1
	// 1 2 2 1 0

	static char[][] M = new char[5][5];

	public static void main(String[] args) {

		M[0][0] = 'O';
		M[0][1] = 'O';
		M[0][2] = 'O';
		M[0][3] = 'O';
		M[0][4] = 'G';

		M[1][0] = 'O';
		M[1][1] = 'W';
		M[1][2] = 'W';
		M[1][3] = 'O';
		M[1][4] = 'O';

		M[2][0] = 'O';
		M[2][1] = 'O';
		M[2][2] = 'O';
		M[2][3] = 'W';
		M[2][4] = 'O';

		M[3][0] = 'G';
		M[3][1] = 'W';
		M[3][2] = 'W';
		M[3][3] = 'W';
		M[3][4] = 'O';

		M[4][0] = 'O';
		M[4][1] = 'O';
		M[4][2] = 'O';
		M[4][3] = 'O';
		M[4][4] = 'G';

		System.out.println("Initial Matrix\n");
		CommonUtils.print_2D_matrix(M);

		int minimum_distance = 0;
		minimum_distance = solvePathPuzzle(0, 0, minimum_distance);
		System.out.println("Minimum Distance = " + minimum_distance);
		System.out.println("Initial Matrix\n");
		CommonUtils.print_2D_matrix(M);

	}

	private static int solvePathPuzzle(int i, int j, int min) {
		if (!safe_cell(i, j))
			return 0;
		System.out.println(M[i][j]);
		if (M[i][j] == 'W')
			return 0;
		if (M[i][j] == 'G')
			return 0;
		if ((M[i][j] == 'O'))
			return 1 + minimumOf(min, solvePathPuzzle(i, j + 1, min), // GO
																		// RIGHT
					solvePathPuzzle(i + 1, j, min)); // GO DOWN
		/* solvePathPuzzle(i - 1, j, min)), , solvePathPuzzle(i - 1, j, min)); */
		M[i][j] = 'R';
		return min;

	}

	private static int minimumOf(int min1, int min2, int min3, int min4, int min5) {
		return minimumOf(min1, minimumOf(min2, minimumOf(min3, minimumOf(min4, min5))));
	}

	private static int minimumOf(int i, int j) {
		return i > j ? j : i;
	}

	private static int minimumOf(int i, int j, int k) {
		return minimumOf(i, minimumOf(j, k));
	}

	private static int minimumOf(int i, int j, int k, int l) {
		return minimumOf(i, minimumOf(j, minimumOf(k, l)));
	}

	private static boolean safe_cell(int i, int j) {
		return i < M.length && j < M[0].length && i >= 0 && j >= 0;
	}

}
