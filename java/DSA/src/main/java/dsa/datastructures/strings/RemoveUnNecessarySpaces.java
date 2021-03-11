package dsa.datastructures.strings;

public class RemoveUnNecessarySpaces {

    public static void main(String[] args) {
        String s = " I      live    on     earth ";
        System.out.println(s);
        String newS = removeUnnecessaryStrings(s);
        System.out.println(newS);
    }

    private static String removeUnnecessaryStrings(String s) {
        /*
         * StringBuffer tokens = new StringBuffer(); for (String s1 : s.split(" "))
         * tokens.append(s1); return tokens.toString();
         */

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (i != 0) {
                    continue;
                } else {
                    i++;
                }
            }
            if (i > 0 && !Character.isWhitespace(c)) {
                i = 0;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
