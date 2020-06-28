package problem.misc;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(final String[] args) {
		final String s = "leetcode";
		final Set<String> dict = new HashSet<>();
		dict.add("pleet");
		dict.add("code");
		dict.add("leet");
		System.out.println(wordBreak(s, dict));
	}

	public static boolean wordBreak(final String s, final Set<String> dict) {
		final boolean[] t = new boolean[s.length() + 1];
		t[0] = true;

		for (int i = 0; i < s.length(); i++) {
			if (!t[i]) {
				continue;
			}

			for (final String word : dict) {
				final int len = word.length();
				final int end = i + len;

				if (end > s.length()) {
					continue;
				}
				if (s.substring(i, end).equals(word)) {
					t[end] = true;
				}
			}
		}

		return t[s.length()];
	}
}
