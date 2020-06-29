package dsa.tries;

public class TestTrie {

	public static void main(final String[] args) {

		final Trie dict = new Trie();
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");

		String input = "caterer";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));

		input = "basement";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));

		input = "are";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));

		input = "arex";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));

		input = "basemexz";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));

		input = "xyz";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
	}
}
