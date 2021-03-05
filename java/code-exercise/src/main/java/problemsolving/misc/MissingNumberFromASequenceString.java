package problemsolving.misc;

import util.CommonUtils;

public class MissingNumberFromASequenceString {

    private static Number findMissingNumberFromSequenceString(String str) {
        int nbrOfDigitsInFirstNbr = 0;
        int firstIdx = 0;
        int secIdx = 1;
        // setting range here
        int firstNbr;
        int lastNbr;
        // finding first number of the seq
        while (true) { // infinite loop
            int n1 = Integer.valueOf(str.substring(0, (firstIdx + 1)));
            int n2 = Integer.valueOf(str.substring((firstIdx + 1), 2 * secIdx));
            if ((n2 - n1) == 1) {
                nbrOfDigitsInFirstNbr += firstIdx;
                firstNbr = n1;
                break;
            } else {
                firstIdx += 1;
                secIdx += firstIdx;
                nbrOfDigitsInFirstNbr = firstIdx;
                continue;
            }
        }

        // now finding the second number of the seq, do the reverse as for the
        // first
        int lastIdx = -1;
        int secondLastIdx = -1;

        String reverseStr = CommonUtils.reverse(str);

        // finding first number of the seq
        while (true) { // infinite loop

            int n1 = Integer.valueOf(str.substring(0, (firstIdx + 1)));
            int n2 = Integer.valueOf(str.substring((firstIdx + 1), 2 * secIdx));

            if ((n1 - n2) == 1) {
                nbrOfDigitsInFirstNbr += firstIdx;
                lastNbr = n1;
                break;
            } else {

                firstIdx += 1;
                secIdx += firstIdx;
                nbrOfDigitsInFirstNbr = firstIdx;
                continue;
            }
        }

        int n1 = Integer.valueOf(str.substring(0, nbrOfDigitsInFirstNbr));
        while (true && lastNbr > firstNbr) { // again infinite loop

            if (!(str.contains(String.valueOf(n1))))
                return n1;
            else
                n1 += 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        String str = "9899100101103104105";
        String str2 = "12345789";

        Number nbr = findMissingNumberFromSequenceString(str);

        System.out.println(nbr);
    }
}
