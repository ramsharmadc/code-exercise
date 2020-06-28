package lang.StringCheck;

public class CheckHashCodeOfStrings {

	public static void main(String[] args) {
		String strObj1 = new String("HELLO");
		String strObj2 = new String("HELLO");
		String str1 = "HELLO";
		String str2 = "HELLO";
		System.out.println("strObj1.equals(strObj2) is " + strObj1.equals(strObj2)); // true
		System.out.println("strObj1 == strObj2 is " + (strObj1 == strObj2)); // false
		System.out.println("strObj1.equals(str1) is " + strObj1.equals(str1)); // true
		System.out.println("str1.equals(str2) is " + str1.equals(str2)); // true
		System.out.println("str1 == str2 is " + (str1 == str2)); // true
		System.out.println("str1.hashCode() - " + str1.hashCode());
		System.out.println("str2.hashCode() - " + str2.hashCode());
		System.out.println("strObj1.hashCode() - " + strObj1.hashCode());
		System.out.println("strObj1.hashCode() - " + strObj2.hashCode());
	}
}
