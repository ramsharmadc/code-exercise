package dsa;

/**
 * long paragraph of string
 * word wrap after 80 chars
 * if at 80th in middle word, the whole word goes to new line
 * <p>
 * Join by Phone  * US: +13017158592 * United Kingdom: +442080806592 * Hungary:\n +3617010488 * Hong Kong SAR: +85258033731 * Japan: +81363628317 Conference Room - sip:93536905331@zoomcrc.com * Alternate phone numbers
 * http://zoom.us/test
 */
public class Test1 {

    public static String wordWrap(String s) {
        StringBuilder wrapdStr = new StringBuilder();
        if (s == null || s.equals(" ") || s.trim().equals("") || s.length() <= 80) {
            wrapdStr.append(s);
            return wrapdStr.toString();
        }

        String[] tokens = s.split(" ");
        int colLenWithNextToken = 0;

        for (String word : tokens) {
            if (colLenWithNextToken + word.length() == 79) {
                wrapdStr.append(word);
                wrapdStr.append("\n");
                colLenWithNextToken = 0;
            } else if (colLenWithNextToken + word.length() > 80) {
                wrapdStr.append("\n");
                wrapdStr.append(word);
                colLenWithNextToken = 0;
            } else {
                wrapdStr.append(word);
                wrapdStr.append(" ");
                colLenWithNextToken += word.length() + 1;
            }
        }

        return wrapdStr.toString();
    }

    public static void main(String[] args) {
        String s = "Join by Phone  * US: +13017158592 * United Kingdom: +442080806592 * Hungary: +3617010488 * Hong Kong SAR: +85258033731 * Japan:";
        String wrapdStr = wordWrap(s);
//        System.out.println(s);
        System.out.println(wrapdStr);
    }

}
