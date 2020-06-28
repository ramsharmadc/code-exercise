package problem.misc;

import java.util.HashSet;
import java.util.Set;

public class StringCheck {

	public static void main(String[] args) {

		String a = "Ram";
		String c = "Ram";

		String b = new String("Ram");
		String d = new String("Ram");

		System.out.println((a == b));
		System.out.println((a == c));
		System.out.println((b == d));

		System.out.println((a.equals(b)));

		Set<String> set = new HashSet<String>();

		set.add(a);
		set.add(b);
		set.add(c);
		set.add(d);

		System.out.println(set.size());
		System.out.println(set);

		System.out.println(new StringCheck());
	}
}
