package google;

import problem.util.CommonUtils;

/**
 * Created by ramsh on 17-04-2016.
 */
public class Jam1TheLastWord {
	public int count = 0;

	public static void main(String args[]) throws Exception {
		Jam1TheLastWord obj = new Jam1TheLastWord();
		obj.permute("eihr");
		obj.permute("ewids".toCharArray(), 0, "ewids".length() - 1);
	}

	private void permute(String str) throws Exception {
		final int start = 0;
		final int end = (str.length() - 1);
		final char[] allChars = str.toCharArray();
		permute(allChars, start, end);
	}

	private void permute(char[] str, int start, int end) throws Exception {
		if (start == end) {
			System.out.println("Permutation" + (++count) + "-[" + CommonUtils.arrayAsString(str) + "]");
		} else {
			for (int j = start; j <= end; j++) {
				swap(str, start, j);
				permute(str, (start + 1), end);
				swap(str, start, j);
			}
		}
	}

	private void swap(final char[] chars, final int x, final int y) throws Exception {
		char temp;
		temp = chars[x];
		chars[x] = chars[y];
		chars[y] = temp;
	}
}
