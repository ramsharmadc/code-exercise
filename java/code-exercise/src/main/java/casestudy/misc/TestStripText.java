package casestudy.misc;

import java.util.Arrays;

public class TestStripText {

    public static void main(String[] args) {
        int totalProd = 1;

        int[] input = new int[]{3, 1, 6, 4};
        for (int i = 0; i < input.length; i++) {
            totalProd = totalProd * input[i];
        }

        int[] outputArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            outputArray[i] = totalProd / input[i];
        }

        // return outputArray ;

        System.out.println(Arrays.toString(outputArray));
    }
}
