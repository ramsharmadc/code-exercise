package dsa.problemsolving.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnixWC {

    public static void count(String str) {

        // System.out.println(str);

        long totalwords1 = 0;
        int lines = 0;
        int chars = 0;
        lines = str.split("\n").length;
        totalwords1 += countWords(str);
        chars = str.toCharArray().length;

        System.out.print(lines + " " + totalwords1 + " " + chars);
    }

    private static long countWords(String line) {

        long numWords = 0;
        int index = 0;
        boolean prevWhitespace = true;

        while (index < line.length()) {
            char c = line.charAt(index++);
            boolean currWhitespace = Character.isWhitespace(c);

            if (prevWhitespace && !currWhitespace) {
                numWords++;
            }
            prevWhitespace = currWhitespace;
        }
        return numWords;
    }

    public static void main(String[] args) {

        System.out.print("Enter the strings: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringBuffer strBuf = new StringBuffer();

        try {
            while ((str = br.readLine()) != null && !(str.equals(""))) {
                strBuf.append(str).append("\n");

            }
            System.out.println(strBuf);

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

        count(strBuf.toString());
    }
}
