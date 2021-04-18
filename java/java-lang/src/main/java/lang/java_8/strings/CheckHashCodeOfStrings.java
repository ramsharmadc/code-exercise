package lang.java_8.strings;

public class CheckHashCodeOfStrings {

    public static void main(String[] args) {
        String strObj1 = "HELLO";
        String strObj2 = "HELLO";
        String str1 = "HELLO";
        String str2 = "HELLO";
        String str_obj = new String("HELLO");
        System.out.println("strObj1.equals(strObj2) is " + strObj1.equals(strObj2)); // true
        System.out.println("strObj1 == strObj2 is " + (strObj1 == strObj2)); // true
        System.out.println("strObj1.equals(str1) is " + strObj1.equals(str1)); // true
        System.out.println("str1.equals(str2) is " + str1.equals(str2)); // true
        System.out.println("str1 == str2 is " + (str1 == str2)); // true
        System.out.println("str_obj == strObj1 is " + (str_obj == strObj1)); // false

        System.out.println("str1.hashCode() - " + str1.hashCode());
        System.out.println("str2.hashCode() - " + str2.hashCode());
        System.out.println("strObj1.hashCode() - " + strObj1.hashCode());
        System.out.println("strObj1.hashCode() - " + strObj2.hashCode());
        System.out.println("str_obj.hashCode() - " + str_obj.hashCode());

        System.out.println(System.identityHashCode(strObj1));
        System.out.println(System.identityHashCode(null));
    }
}
