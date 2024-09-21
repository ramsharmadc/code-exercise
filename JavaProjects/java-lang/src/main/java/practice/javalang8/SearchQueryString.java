package practice.javalang8;

import java.util.*;

public class SearchQueryString {

    private Map<Character, Integer> tokenMap;

    private void resetTokenMap() {
        tokenMap = new HashMap<>();
    }

    private void initializeMap(String string) {

        resetTokenMap();

        if (isValidString(string)) {
            for (Character c : string.toCharArray()) {
                if(!Character.isWhitespace(c)) {
                    tokenMap.put(c, 0);
                }
            }
        }
    }

    private boolean searchQueryString(String token) {

        if (isValidString(token)) {

            for (Character c : token.toCharArray()) {
                if (tokenMap.containsKey(c)) {
                    tokenMap.put(c, tokenMap.get(c) + 1);
                }
            }

            boolean isValid = true;

            for (Character c : tokenMap.keySet()) {
                if (tokenMap.get(c) < 1) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        } else return false;
    }

    public List<String> search(String input, String queryString) {

        if (isValidString(input) && isValidString(queryString)) {

            List<String> validWords = new LinkedList<>();
            String[] tokens = input.split(" ");

            for (String eachToken : tokens) {

                initializeMap(normalize(queryString));

                if (searchQueryString(normalize(eachToken))) {
                    validWords.add(eachToken);
                }
            }
            return validWords;
        } else return Collections.emptyList();
    }

    private boolean isValidString(String str) {
        return str != null && str.length() > 0;
    }

    private String normalize(String str) {
        if (isValidString(str)) {
            return str.toLowerCase();
        } else return str;
    }
}
