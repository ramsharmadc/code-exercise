package lang.jdk8.basics.clasz;

import java.io.DataInputStream;
import java.util.*;

public class Solution {

	@SuppressWarnings({ "deprecation" })
	public static void main(String args[]) throws Exception {

		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		DataInputStream is = new DataInputStream(System.in);

		String resources = is.readLine();

		char[] charArr = resources.toCharArray();

		List<Character> resourceList = new LinkedList<Character>();
		for (char c : charArr) {
			resourceList.add(c);
		}

		String orderOfUsage = is.readLine();
		char[] usageArr = orderOfUsage.toCharArray();
		Map<Character, Integer> orderMap = new LinkedHashMap<Character, Integer>();

		for (char c : usageArr) {
			if (orderMap.containsKey(c)) {
				int temp = orderMap.get(c);
				temp += 1;
				orderMap.put(c, temp);
			} else {
				orderMap.put(c, 1);
			}
		}
	}

	static class MyComparator implements Comparator<Map.Entry<Character, Integer>> {

		public int compare(Map.Entry<Character, Integer> _e1, Map.Entry<Character, Integer> _e2) {

			Map.Entry<Character, Integer> e1 = (Map.Entry<Character, Integer>) _e1;
			Map.Entry<Character, Integer> e2 = (Map.Entry<Character, Integer>) _e2;

			if (e1.getValue() > e2.getValue())
				return 1;
			else
				return 0;
		}
	}
}
