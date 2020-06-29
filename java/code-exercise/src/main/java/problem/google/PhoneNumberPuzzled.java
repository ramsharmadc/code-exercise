package problem.google;

import java.util.Arrays;

/**
 * Created by ramsh on 30-04-2016.
 */
public class PhoneNumberPuzzled {
	static String[] LETTER_TO_DIGIT = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
			"NINE" };

	public static void main(String[] args) {
		// String clue = "OZONETOWER";
		String clue = "OZONEER";
		String phoneNumber = "";
		decryptPhoneNumber(clue.toCharArray(), phoneNumber);
	}

	static void decryptPhoneNumber(char[] clue, String ph) {
		if (clue.length == 0)
			return;

		// if( containsStr(ph, LETTER_TO_DIGIT) )
		// cutArrayShort(clue, new int[]{0,1,2});

		for (int i = 0; i < clue.length; i++) {
			ph = String.valueOf(clue[i]);
			System.out.println("clue[" + i + "]" + "=" + clue[i]);
			for (int j = i; j < clue.length; j++) {
				if (j != i) {
					ph = ph.concat(String.valueOf(clue[j]));
					System.out.println("ph" + "=" + ph);
					if (containsStr(ph, LETTER_TO_DIGIT)) {
						clue = removeFoundCharsFromOriginalArr(ph, clue);
						System.out.println("remaining clue = " + Arrays.toString(clue));
						break;
					}
				}
			}
		}
	}

	private static char[] removeFoundCharsFromOriginalArr(String ph, char[] clue) {
		System.out.println("Removing " + ph + " from " + Arrays.toString(clue));
		Arrays.sort(clue);
		char[] foundChars = ph.toCharArray();
		Arrays.sort(foundChars);
		System.out.println(clue);
		System.out.println(foundChars);
		int newStartIndx = foundChars.length;
		clue = arrayRearrange(clue, newStartIndx, clue.length);

		System.out.println("new clue = " + Arrays.toString(clue));
		return clue;
	}

	private static char[] arrayRearrange(char[] clue, int start, int end) {
		char[] newArr = new char[clue.length - start];
		for (int i = start; i < clue.length; i++) {
			newArr[i - start] = clue[i];
		}
		System.out.println("New Array = " + Arrays.toString(newArr));
		return newArr;
	}

	static boolean containsStr(final String str, final String[] arr) {
		for (int j = 0; j < arr.length; j++) {
			char[] a = str.toCharArray();
			Arrays.sort(a);
			char[] d = arr[j].toCharArray();
			Arrays.sort(d);

			if (equalArrays(a, d)) {
				System.out.println(a);
				System.out.println(d);
				return true;
			}
		}
		return false;
	}

	private static boolean equalArrays(char[] a, char[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
}
