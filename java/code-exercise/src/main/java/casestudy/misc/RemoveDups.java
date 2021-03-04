package casestudy.misc;

public class RemoveDups {

    public static boolean checkDuplicates(final String str) {

        //
        for (final char c : str.toLowerCase().toCharArray()) {

            if (str.indexOf(c) != str.lastIndexOf(c))
                return true;
            else {
                continue;
            }
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        // we will use 1 or 2 variable(s)

        final String str = "abcaaadd";
        // str ="abcdefghijklmnopqrstuvwxyz";

        System.out.println("String is :: " + str);
        System.out.println(checkDuplicates(str));
    }

}
