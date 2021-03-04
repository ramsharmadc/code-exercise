package dsa.tries;

import java.util.HashMap;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode((char) 0);
    }

    // The main method that finds out the longest string 'input'
    public String getMatchingPrefix(final String input) {
        // String result = Messages.getString("Trie.0"); // Initialize resultant string
        // //$NON-NLS-1$
        String result = "";
        final int length = input.length(); // Find length of the input string
        TrieNode crawl = root;

        // Iterate through all characters of input string 'str' and traverse
        // down the Trie
        int level, prevMatch = 0;
        for (level = 0; level < length; level++) {

            // Find current character of str
            final char ch = input.charAt(level);

            // HashMap of current Trie node to traverse down
            final HashMap<Character, TrieNode> child = crawl.getChildren();

            // See if there is a Trie edge for the current character
            if (child.containsKey(ch)) {
                result += ch; // Update result
                crawl = child.get(ch); // Update crawl to move down in Trie
                // If this is end of a word, then update prevMatch
                if (crawl.isEnd()) {
                    prevMatch = level + 1;
                }
            } else
                break;
        }

        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if (!crawl.isEnd())
            return result.substring(0, prevMatch);
        else
            return result;
    }

    // Method to insert a new word to Trie
    public void insert(final String word) {
        // Find length of the given word
        final int length = word.length();

        TrieNode crawl = root;

        // Traverse through all characters of given word
        for (int level = 0; level < length; level++) {
            final HashMap<Character, TrieNode> child = crawl.getChildren();
            final char ch = word.charAt(level);
            // If there is already a child for current character of given word
            if (child.containsKey(ch)) {
                crawl = child.get(ch);
            } else // else create a child
            {
                final TrieNode temp = new TrieNode(ch);
                child.put(ch, temp);
                crawl = temp;
            }
        }
        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
    }

    static class TrieNode {
        private final char value;
        private final HashMap<Character, TrieNode> children;
        private boolean bIsEnd;

        public TrieNode(char ch) {
            value = ch;
            children = new HashMap<>();
            bIsEnd = false;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public char getValue() {
            return value;
        }

        public boolean isEnd() {
            return bIsEnd;
        }

        public void setIsEnd(boolean val) {
            bIsEnd = val;
        }
    }

}
