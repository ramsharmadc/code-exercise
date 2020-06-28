package problem.misc;

public class RecursiveReverseString {

	public static void main(String[] args) {
		String str = reverseStringRecursion("this is recursion and you will see. it's so powerful");
		System.out.println(str);
		String expectedOutput = "lufrewop os s'ti .ees lliw uoy dna noisrucer si siht";
		System.out.println(str.equals(expectedOutput));
		System.out.println(reverseStringRecursion("lufrewop os s'ti .ees lliw uoy dna noisrucer si siht"));
	}

	public static String reverseStringRecursion(String s) {
		if (s.length() == 0)
			return s;
		return s.charAt(s.length() - 1) + reverseStringRecursion(s.substring(0, s.length() - 1));
	}

}
