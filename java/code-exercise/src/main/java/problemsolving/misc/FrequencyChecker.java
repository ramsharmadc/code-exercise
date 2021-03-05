package problemsolving.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Grzywacz, Pawel <pawel.grzywacz@citi.com> 3:40 PM (1 minute ago) to me, Arkadiusz You have two
 * inputs, a list of eligible words, and a sentence. Please find the most frequent eligible word
 * that occurs in a sentence. For example: the list of words is: Java, programming, spring. In the
 * sentence “I like Java programming with Spring and Spring is the best framework�? the word
 * Spring is the most frequent word
 */
public class FrequencyChecker {

    public String getMostFrequentWord(List<String> eligibleWords, String statement) {

        if (eligibleWords == null || eligibleWords.isEmpty())
            return "";
        if (statement == null || statement.equals(""))
            return "";

        Map<String, Integer> frequency = new HashMap<>();

        Arrays.asList(statement.split(" ")).stream().forEach(x -> {
            if (frequency.containsKey(x)) {
                frequency.put(x, frequency.get(x) + 1);
            } else {
                frequency.put(x, 1);
            }
        });

        String mostFrequentWord = "";
        int maxFrequency = 0;

        for (String e : eligibleWords) {
            if (frequency.containsKey(e) && frequency.get(e) > maxFrequency) {
                mostFrequentWord = e;
                maxFrequency = frequency.get(e);
            }
        }
        return mostFrequentWord;
    }
}
