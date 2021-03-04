package casestudy.misc;

public class Count1sInByteArray {

    public static int count1s(byte[] arr) {

        int c = 0;
        for (byte b : arr) {
            for (int i = 0; i < 8; i++) {
                // System.out.println( (b & 1));
                if ((b & 1) == 1) {
                    c++;
                }

                // b >>>= (byte) 1;
                // OR
                b = (byte) (b >>> 1);
            }
        }
        return c;
    }

    public static int count1sByMod(byte[] arr) {

        int c = 0;

        for (byte b : arr) {
            while (b > 0) {
                if ((b % 2) == 1)
                    c++;
                b = (byte) (b / 2);
            }
        }
        return c;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        byte[] arr = {3, 3};

        System.out.println(count1s(arr));
        System.out.println(count1sByMod(arr));
    }
}
