package practice.javalang8.wrapper;

public class WrappersAndPrimitives {

    public static void main(final String[] args) {

        final Integer intObj1 = Integer.valueOf(47);
        final Integer intObj2 = Integer.valueOf(47);

        System.out.println(intObj1 == intObj2);
        System.out.println(intObj1.equals(intObj2));

        final int intPrim1 = 47;
        final int intPrim2 = 47;

        System.out.println(intPrim1 == intPrim2);
    }

}
