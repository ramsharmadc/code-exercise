package problem.misc;

import java.util.LinkedHashSet;
import java.util.Set;

public class TilesAndDictionary {

	private static String tile = "SAPAPER";
	private static String[] dictionaryString = { "A", "AA", "AAA", "APE", "PEA", "PARE", "PEAR", "FEAR", "SPARE",
			"APPEARS", "REAPPEARS" };
	private static Set<String> dictionary = new LinkedHashSet<>();

	public static void main(String[] args) {

		for (int i = 0; i < dictionaryString.length; i++) {
			dictionary.add(dictionaryString[i]);
		}

		Set<String> set = new LinkedHashSet<>();
		char[] chars = tile.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			StringBuilder str = new StringBuilder();
			str.append(String.valueOf(chars[i]));
			set.add(str.toString());

			for (int j = 0; j < chars.length; j++) {
				// if(chars[i] != chars[j]){
				str.append(String.valueOf(chars[j]));
				set.add(str.toString());
				// }
			}
		}

		System.out.println(dictionary);
		System.out.println(set);

		for (String str : set) {
			if (dictionary.contains(str))
				System.out.println(str);
		}
	}
}
