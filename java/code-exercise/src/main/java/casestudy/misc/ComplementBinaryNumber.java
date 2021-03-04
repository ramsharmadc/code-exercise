package casestudy.misc;

public class ComplementBinaryNumber {

    public static void main(String[] args) {

        System.out.println(toBinary(50));

        System.out.println(toDecimal(toBinary(50)));

        System.out.println(toDecimal(complemet(toDecimal(toBinary(50)))));
    }

    static int toBinary(int n) {

        int[] binary = new int[25];
        int index = 0;
        int binaryNumber = 0;

        while (n > 0) {

            binary[index++] = n % 2;
            n = n / 2;
        }

        for (int i = index - 1; i >= 0; i--) {

            binaryNumber = ((binaryNumber * 10) + binary[i]);
        }

        return binaryNumber;
    }

    static int toDecimal(int binary) {

        int decimal = 0;
        int power = 0;

        while (true) {

            if (binary == 0) {
                break;
            } else {
                int tmp = binary % 10;
                decimal += tmp * Math.pow(2, power);
                binary = binary / 10;
                power++;
            }
        }
        return decimal;
    }

    static int complemet(int n) {

        int[] binary = new int[25];
        int index = 0;
        int complementBinaryNumber = 0;

        while (n > 0) {

            binary[index++] = n % 2;
            n = n / 2;
        }

        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 1)
                binary[i] = 0;
            else
                binary[i] = 1;
        }

        for (int i = index - 1; i >= 0; i--) {

            complementBinaryNumber = ((complementBinaryNumber * 10) + binary[i]);
        }

        return complementBinaryNumber;
    }
}
