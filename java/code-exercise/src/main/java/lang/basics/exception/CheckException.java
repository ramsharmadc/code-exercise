package lang.basics.exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckException<E> {

	public static void main(String[] args) // throws Throwable
	{
		// check the resource allocation here in jdk1.7
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			new CheckException<Object>().justaMethod();
			throw new Throwable();
		}

		// catch(E instanceof Throwable) {}

		catch (Exception e) {
			System.out.println("Exception thrown :" + e.getLocalizedMessage());

		} catch (Throwable th) {
		} // this is fine as this is superclass of e
			// catch(Exception ee) {} // Exception already handled in the above
			// 'catch' clause
			// catch(RuntimeException re) { } // this is also a compile error

	}

	public void justaMethod() {
		try {
			// throw new ClassCastException();
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Excpetion caught : " + e.getMessage());
			// throw new NullPointerException();
			// throw new Exception(); // u can't uncomment this line
		}
	}
}
