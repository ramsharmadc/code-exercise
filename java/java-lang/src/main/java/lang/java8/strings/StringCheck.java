package lang.java8.strings;

import java.util.StringTokenizer;

public class StringCheck {

    public static void main(String[] args) {

        String tokenOfStrings = "Hello We can get this done";

        SampleString sampleString1 = new SampleString("raammsharma");
        System.out.println(sampleString1.value());
        sampleString1.setCharAt(5, "kishan");
        System.out.println(sampleString1.value());

        SampleString sampleString2 = new SampleString("");
        System.out.println(sampleString2.value());
        sampleString2.setCharAt(1, "kishan");
        System.out.println(sampleString2.value());

        // interesting string behaviour
        String a = "Java is great.";
        System.out.println(a);
        String b = a.substring(5); // b is the String "is great."
        System.out.println(b);
        String c = a.substring(5, 7);// c is the String "is"
        System.out.println(c);
        String d = a.substring(5);// d is "is great."
        System.out.println(d);

        StringTokenizer stringTokenizer = new StringTokenizer("Hello|World|Of|Java|Strings", "|");
        while (stringTokenizer.hasMoreTokens())
            System.out.println(stringTokenizer.nextToken());
    }

    static class SampleString // extends String
    {
        private String str;

        public SampleString(String str) {
            this.str = str;
        }

        public void setCharAt(int i, String s) {
            if (i > this.str.length())
                return;
            StringBuilder stringBuilder = new StringBuilder(this.str.substring(0, i));
            stringBuilder.append(s);
            stringBuilder.append(this.str.substring(i));
            this.str = stringBuilder.toString();
        }

        public String value() {
            return this.str;
        }
    }
}
