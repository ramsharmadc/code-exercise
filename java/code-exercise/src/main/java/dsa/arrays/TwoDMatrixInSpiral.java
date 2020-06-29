package dsa.arrays;

public class TwoDMatrixInSpiral {

	public static void main(String[] args) {

		int[][] d = new int[3][3];

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				d[i][j] = (i + 1) * (j + 1) * 20;
			}
		}

		print2DArray(d);

		printSpiral(d);
	}

	private static void printSpiral(int[][] d) {

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print2DArray(int[][] d) {

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
}
