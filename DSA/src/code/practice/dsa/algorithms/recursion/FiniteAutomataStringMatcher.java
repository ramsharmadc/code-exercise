package dsa.algorithms.recursion;

public class FiniteAutomataStringMatcher {
    String targetString;
    String pattern;

    public FiniteAutomataStringMatcher(String t, String p) {
        targetString = t;
        pattern = p;
    }

    public static void main(String[] args) {
    }

    private boolean finiteAutomataMatch() {
        String t = targetString;
        String p = pattern;
        return false;
    }

    public boolean isPatternMatching() {
        return finiteAutomataMatch();
    }
}
