package problem.misc;

public class FirstCharWithOneOccurrence {

	public static Character firstAndOnce(String str) {

		for (Character ch : str.toLowerCase().toCharArray()) {
			if (str.toLowerCase().indexOf(ch) == str.toLowerCase().lastIndexOf(ch)) {
				return ch;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		String str = "this is DZone's Thursday Code Puzzler";
		System.out.println(firstAndOnce(str));
	}
}
