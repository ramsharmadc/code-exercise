package answers;

import java.io.*;
import java.util.*;

public class ComplementaryPairs {

	public Set<IndexPair> findKComplementaryPairs(int[] a, int K) {

		final Map<Integer, Integer> reference = new HashMap<>();

		// to keep non-equal and non-duplicate pairs, check IndexPair
		final Set<IndexPair> kcomplPairs = new HashSet<>();

		// to find a pair, the array should have at least 2 elements
		if (a == null || a.length < 2)
			return kcomplPairs;

		// keep the array element mapped to it's index in memory.
		// Runs in complexity of O(n)
		for (int i = 0; i < a.length; i++) {
			reference.put(a[i], i);
		}

		// Using the reference find the pairs,
		// Runs in complexity O(n)
		for (int left = 0; left < a.length; left++) {

			// if reference has other part, take its index
			if (reference.containsKey(K - a[left])) {
				int right = reference.get(K - a[left]);
				if (left != right) {
					IndexPair pair = new IndexPair(left, right);
					kcomplPairs.add(pair);
				}
			}
		}

		return kcomplPairs;
	}

	private static class IndexPair {

		private int left;
		private int right;

		public IndexPair(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public int getLeft() {
			return left;
		}

		public void setLeft(int left) {
			this.left = left;
		}

		public int getRight() {
			return right;
		}

		public void setRight(int right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "(" + left + "," + right + ")";
		}

		@Override
		public int hashCode() {
			// a duplicate pair should give same hashcode
			return Objects.hash(left + right);
		}

		@Override
		/**
		 * a pair is equal if it has same left and right OR it is a duplicate these 2
		 * pairs are duplicate: (2,1) and (1,2)
		 */
		public boolean equals(Object obj) {

			if (obj == null)
				return false;

			if (!(obj instanceof IndexPair))
				return false;

			if (obj == this)
				return true;

			IndexPair that = (IndexPair) obj;

			return (this.left == that.left && this.right == that.right)
					|| (this.left == that.right && this.right == that.left);
		}
	}

	/**
	 * Driver program for testing the ComplementaryPairs. Reads libs as input from a
	 * test file ".\libs\ComplementaryPairs.txt" Writes output at the end of the
	 * same file
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final File directory = new File("./");
		final String testFile = ".\\libs\\ComplementaryPairs.txt";
		final ComplementaryPairs complementaryPairsFinder = new ComplementaryPairs();
		try (
				// auto closeable resources
				final Scanner inputScanner = new Scanner(new FileInputStream(testFile));
				final FileWriter outputWriter = new FileWriter(testFile, true);) {
			// append output section to the file
			outputWriter.write("\n#output\n");
			String nxtLiteral;

			// runs through each input array and libs it
			while (inputScanner.hasNext()) {
				nxtLiteral = inputScanner.nextLine();

				if (nxtLiteral != null && !nxtLiteral.isEmpty()) {
					// break when output section begins
					if (nxtLiteral.equalsIgnoreCase("#output"))
						break;

					// skip comment
					if (nxtLiteral.charAt(0) == '#')
						continue;

					// take the literal as input an test
					List<Integer> inputArr = new ArrayList<>();
					String[] inputSplit = nxtLiteral.split(" ");
					if (inputSplit.length != 2) {
						throw new RuntimeException("Input not valid. Please read the README.txt");
					}
					int K = Integer.valueOf(inputSplit[1].trim());
					Arrays.stream(inputSplit[0].split(",")).forEach(x -> inputArr.add(Integer.valueOf(x.trim())));
					int[] testArr = new int[inputArr.size()];
					for (int i = 0; i < inputArr.size(); i++) {
						testArr[i] = inputArr.get(i);
					}
					outputWriter.write(complementaryPairsFinder.findKComplementaryPairs(testArr, K) + "\n");
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Input file \'ComplementaryPairs.txt\' not found at location - "
					+ directory.getAbsolutePath() + "\\test\\");
			System.out.println("Please refer README.txt for ComplementaryPairs");
		} catch (IOException e) {
			System.out.println("Some I/O error while handling files. Details - " + e.getMessage());
		}
	}
}
