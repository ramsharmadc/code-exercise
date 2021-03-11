package dsa.problemsolving.misc;

/**
 * Write code to remove alternate duplicate characters (case insensitive) from a string in place.
 * For eg. "Today is the day" -> "Today ishe ". Also give test cases.
 */
public class RemoveAlternateDuplicate {

    public static void main(final String[] args) {

        new RemoveAlternateDuplicate().removeDups();
    }

    private void removeDups() {

        String str = "Today is the day";

        str = DuplicatesinString.removeDuplicateCharactersFromAString(str);
        System.out.println(str);
    }

}
