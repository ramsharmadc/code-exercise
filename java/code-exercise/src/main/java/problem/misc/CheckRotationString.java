package problem.misc;

public class CheckRotationString {
	public static Boolean checkIsRotation(String str1, String str2) {
		// return str1.concat(str1).contains(str2);
		// OR
		return str2.concat(str2).contains(str1);
	}

	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		// check this :: erbottlewaterbottlewat OR waterbottlewaterbottle
		// either of the String if u concat with itself, it has other string in
		// it
		Boolean tORf = checkIsRotation(str1, str2);
		System.out.println(tORf);
	}
}
