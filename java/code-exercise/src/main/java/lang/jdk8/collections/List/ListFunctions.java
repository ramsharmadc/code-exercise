package lang.jdk8.collections.List;

import lang.jdk8.collections.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListFunctions {

	public static void main(String[] args) {

		// list made from an array
		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 18, 9 });
		System.out.println(list);
		Collections.reverse(list);

		System.out.println(collection.max(list)); // check 'max' implementations
	}
}
