package problem.misc;

import java.util.ArrayList;

/**
 * Given a string pattern of 0s, 1s, ?s(wild cards), generate all the 0-1
 * strings that match this pattern Example : 1?00?101 -> [10000101, 10001101,
 * 11000101, 11001101]
 * 
 * @author ram.sharma
 */
public class CreateStringsFromPatterns {

	public static void main(String[] args) {

		String pattern = "1?00?101";
		char[] chars = pattern.toCharArray();

		int countOfWildChars = 0;

		for (int k = 0; k < chars.length; k++) {
			if (chars[k] == '?') {
				countOfWildChars += 1;
			}
		}

		int[] wildCardPos = new int[countOfWildChars];
		int j = 0;

		for (int i = 0; i < chars.length; i++)
			if (chars[i] == '?')
				wildCardPos[j++] = i;

		int numOfCombos = (int) Math.pow(2, wildCardPos.length);
		// System.out.println(numOfCombos);

		ArrayList<int[]> arr = new ArrayList<>();
		int[] temp = new int[wildCardPos.length];

		// making combinations
		for (int m = 0; m < numOfCombos; m++) {
			for (int n = 0; n < wildCardPos.length; n++) {

				temp[n] = n != 0 ? (temp[n - 1] ^ temp[n]) : (1 ^ temp[n]);
				// System.out.print(wildCardPos[n]);
			}

			arr.add(temp);

			StringBuilder strBuild = new StringBuilder();
			strBuild.append(pattern.subSequence(0, wildCardPos[0]));
			strBuild.append(temp[0]);
			strBuild.append(pattern.subSequence(wildCardPos[0] + 1, wildCardPos[1]));
			strBuild.append(temp[1]);
			strBuild.append(pattern.substring(wildCardPos[1] + 1));
			System.out.println(strBuild);
		}

	}
}
