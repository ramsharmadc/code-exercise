package problem.misc;

public class PatternMatching {

	public static void main(final String[] args) {

		final String str = "ramsharma";
		final String pattern = "arm";

		final boolean isMatching = patternMatch(str, pattern);

		System.out.println(isMatching);
	}

	public static boolean patternMatch(final String str, final String pattern) {

		final char[] chrs = str.toCharArray();
		final char[] ptn = pattern.toCharArray();

		final int strLen = str.length();
		final int ptnLen = pattern.length();

		boolean flag = true;

		for (int i = 0; i < (strLen - ptnLen); i++) {

			if (chrs[i] == ptn[i]) {

				if (i == (strLen - ptnLen))
					return flag;
				else {

					flag = true;
					continue;
				}
			} else {
				flag = false;
			}
		}

		return false;
	}

}
