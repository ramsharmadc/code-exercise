package lang.java_8;

public class BitwiseOperations {

    public static void main(String[] args) {

        int max_int = 1 << 30;
        int max_int2 = (int) Math.pow(2, 30);

        System.out.println(max_int);
        System.out.println(max_int2);
        System.out.println(Integer.MAX_VALUE);

        System.out.println("null==null is " + (null == null));
    }
}
