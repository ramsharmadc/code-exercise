package dsa.algos.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPallindromeInString implements DynamicProgramming {

	static Map<String, Integer> mem = new HashMap<>();

	public static void main(String[] args) {
		int countOfPallindromes = findPallindromes("xabaay");
		System.out.println(countOfPallindromes);

		countOfPallindromes = findPallindromesByDP("xabaay");
		System.out.println(countOfPallindromes);
	}

	private static int findPallindromes(String str) {
		if (str == "" || isPallindrome(str)) {
			// System.out.println(str);
			return 0;
		} else {
			int cuts = Integer.MAX_VALUE;
			for (int i = 1; i < str.length(); i++) {
				cuts = Math.min(1 + findPallindromes(str.substring(0, i))
						+ findPallindromes(str.substring(i + 1, str.length())), cuts);
			}

			return cuts;
		}
	}

	public static int findPallindromesByDP(String s) {

		if (s == "" || isPallindrome(s))
			return 0;
		else {
			int cuts = Integer.MAX_VALUE;
			for (int i = 0; i < s.length(); i++) {
				Integer leftSol = 0;
				Integer rightSol = 0;
				String leftPart = s.substring(0, i);
				String rightPart = s.substring(i + 1, s.length());

				if (mem.containsKey(leftPart)) {
					leftSol = mem.get(leftPart);
				} else {
					leftSol = findPallindromesByDP(leftPart);
					mem.put(leftPart, leftSol);
				}

				if (mem.containsKey(rightPart)) {
					rightSol = mem.get(rightPart);
				} else {
					rightSol = findPallindromesByDP(rightPart);
					mem.put(rightPart, rightSol);
				}

				cuts = Math.min(1 + leftSol + rightSol, cuts);
			}

			return cuts;
		}
	}

	public static boolean isPallindrome(String str) {
		int n = str.length();
		if (n == 1)
			return true;
		for (int j = 0; j < n / 2; j++) {
			if (str.charAt(j) != str.charAt(n - j - 1))
				return false;
		}
		return true;
	}
}
