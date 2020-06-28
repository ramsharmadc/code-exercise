package lang.collections.map;

import java.util.*;

public class CheckMap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		String str = map.put("first", "FIRST");
		System.out.println(str);

		str = map.put("first", "SECOND");
		System.out.println(str);

		str = map.put("second", "SECOND");
		System.out.println(str);

		str = map.put("second", "THIRD");
		System.out.println(str);

		// str = map.remove("second");
		System.out.println(str);

		// str = map.remove("second");
		System.out.println(str);

		Set<Map.Entry<String, String>> set = map.entrySet();
		System.out.println(set);

		Map.Entry<String, String> oneEntry = set != null ? set.iterator().next() : null;

		String oldValue = oneEntry != null ? oneEntry.setValue("FOURTH") : null;
		System.out.println(oldValue);

		Set<String> setOfKeys = map.keySet();
		System.out.println(setOfKeys);

		Collection<String> setOfValues = map.values();
		ArrayList<String> valuesAsList = new ArrayList<>(setOfValues);
		System.out.println(setOfValues);
		System.out.println(valuesAsList);

		// System.out.println(map.size());
		// System.out.println(map);
		// System.out.println(Integer.MAX_VALUE);
	}
}
