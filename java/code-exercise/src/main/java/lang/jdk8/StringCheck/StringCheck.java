package lang.jdk8.StringCheck;

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
    }

    static class SampleString //extends String
    {
        private String str;

        public SampleString(String str) {
            this.str = str;
        }

        public void setCharAt(int i, String s) {
            if (i > this.str.length()) return;
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
