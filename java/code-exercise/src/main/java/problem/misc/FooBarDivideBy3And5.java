package problem.misc;

/**
 * Write a function called FooBar that takes input integer n and prints all the
 * numbers from 1 upto n in a new line. If the number is divisible by 3 then
 * print "Foo", if the number is divisible by 5 then print "Bar" and if the
 * number is divisible by both 3 and 5, print "FooBar". Otherwise just print the
 * number. for example FooBar(15) should print as follows: 1 2 Foo 4 Bar Foo 7 8
 * Foo Bar 11 Foo 13 14 FooBar
 * 
 * @author lenovo
 */
public class FooBarDivideBy3And5 {

	public static void main(String[] args) {

		new FooBarDivideBy3And5().printNumbersButMultipleOf3(15);
	}

	void printNumbersButMultipleOf3(int n) {

		for (int i = 1; i <= n; i++) {

			if ((i % 3 == 0) && !(i % 5 == 0))
				System.out.println("Foo");
			else if (!(i % 3 == 0) && (i % 5 == 0))
				System.out.println("Bar");
			else if ((i % 3 == 0) && (i % 5 == 0))
				System.out.println("FooBar");
			else
				System.out.println(i);
		}
	}
}
