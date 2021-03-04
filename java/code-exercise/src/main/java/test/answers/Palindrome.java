package test.answers;

import java.io.*;
import java.util.Scanner;

public class Palindrome {

    /**
     * Driver program for testing the Palindrome. Reads libs as input from a test file
     * ".\libs\Palindrome.txt" Writes output at the end of the same file
     *
     * @param args
     */
    public static void main(String[] args) {
        final File directory = new File("./");
        final String testFile = ".\\libs\\Palindrome.txt";
        final Palindrome palindromeChecker = new Palindrome();
        try (
                // auto closeable resources
                final Scanner inputScanner = new Scanner(new FileInputStream(testFile));
                final FileWriter outputWriter = new FileWriter(testFile, true)) {
            // append output section to the file
            outputWriter.write("\n#output\n");
            String nxtLiteral;

            while (inputScanner.hasNext()) {
                nxtLiteral = inputScanner.nextLine();

                if (nxtLiteral != null && !nxtLiteral.isEmpty()) {
                    // break when output section begins
                    if (nxtLiteral.equalsIgnoreCase("#output"))
                        break;

                    // skip comment
                    if (nxtLiteral.charAt(0) == '#')
                        continue;

                    // take the literal as input an test
                    outputWriter.write(palindromeChecker.isPalindrome(nxtLiteral) + "\n");
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Input file 'Palindrome.txt' not found at location - "
                    + directory.getAbsolutePath() + "\\test\\");
            System.out.println("Please refer README.txt for Palindrome");
        } catch (IOException e) {
            System.out.println("Some I/O error while handling files. Details - " + e.getMessage());
        }
    }

    public boolean isPalindrome(String instr) {

        // a null Or an empty string doesn't qualify
        if (instr == null || instr.isEmpty())
            return false;

        // a single character string is a palindrome
        if (instr.length() == 1)
            return true;

        int lenOffset = instr.length() - 1;
        int midIndex = instr.length() / 2;

        // runs till the middle of the string, with complexity O(n)
        for (int i = 0; i < midIndex; i++) {
            if (instr.charAt(i) != instr.charAt(lenOffset - i))
                return false;
        }
        return true;
    }
}
