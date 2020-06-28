package code.dsa.strings;

public class RepeatOneStringTillContainsSecodString {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";

//        s1= "mar";
//        s2 = "rmarmarmarmarmarmarmarmarmarmarmarmarmarmarmarmarmarm";

        int count = ifRepeatedAContainsB(s1, s2);
        System.out.println((count == 0 ? false : true) + " : " + count);

        int count2 = ifRepeatedStringContainsAnotherRecursion(s1, s2, 0);
        System.out.println((count2 == 0 ? false : true) + " : " + count2);
    }

    private static int ifRepeatedAContainsB(String s1, String s2) {
        int count = -1;
        for (int i = 0; i < 5; i++) {
            System.out.println("i=" + i + " String=" + s1 + " target=" + s2);
            if (s1.contains(s2)) {
                System.out.println("i=" + i + " String=" + s1 + " target=" + s2);
                count = i + 1;
                return count;
            }
            s1 = s1.concat(s1);
        }
        return count;
    }

    public static int ifRepeatedStringContainsAnotherRecursion(String s1, String s2, int n) {
        if (s1.contains(s2)) return n + 1;
        if (n > 5) return -1;
        return ifRepeatedStringContainsAnotherRecursion(s1.concat(s1), s2, n + 1);
    }
}
