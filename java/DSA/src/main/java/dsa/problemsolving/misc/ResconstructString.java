package dsa.problemsolving.misc;

public class ResconstructString {
    final static String[] dictionary =
            new String[]{"a", "is", "valid", "this", "string", "if", "you", "know"};

    public static void main(String[] args) {
        String str = "thisisavalidstringifyouknow";
        String reconstructString = resconstructString(str);
        System.out.println(reconstructString);
    }

    private static String resconstructString(String str) {
        StringBuilder word, toReturnStr = new StringBuilder();
        while (str.length() > 0) {
            int i = 0;
            word = new StringBuilder();
            for (i = 0; i < str.length(); i++) {
                word.append(str.charAt(i));
                if (contains(dictionary, word.toString())) {
                    toReturnStr.append(word + " ");
                    str = str.substring(i + 1);
                    break;
                }
            }
            if (i == str.length())
                break;
        }
        return toReturnStr.toString();
    }

    private static boolean contains(String[] dict, String word) {
        for (String s : dict)
            if (word.equals(s))
                return true;
        return false;
    }
}
