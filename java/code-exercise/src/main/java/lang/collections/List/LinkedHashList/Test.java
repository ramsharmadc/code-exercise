package lang.collections.List.LinkedHashList;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {

		LinkedHashList<String> listCumMap = new LinkedHashList<>();

		listCumMap.add("ZERO");
		listCumMap.add("FIRST");
		listCumMap.add("SECOND");
		listCumMap.add("THIRD");
		listCumMap.add("FOURTH");
		listCumMap.add("FIFTH");

		// System.out.println(listCumMap.get(2));
		// System.out.println(listCumMap);

		for (Iterator<String> itr = listCumMap.iterator(); itr.hasNext();) {
			System.out.println(itr.next());
			// itr.remove();
		}

		// System.out.println(listCumMap);
	}
}
