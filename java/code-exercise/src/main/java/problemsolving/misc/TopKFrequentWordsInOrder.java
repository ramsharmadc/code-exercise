package problemsolving.misc;

import java.util.*;

public class TopKFrequentWordsInOrder {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> topKFrequentWordsInOrder =
                new TopKFrequentWordsInOrder().topKFrequent(words, 2);
        System.out.println(topKFrequentWordsInOrder);
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> dict = new TreeMap<>();

        Queue<Map.Entry<String, Integer>> reverseWords =
                new PriorityQueue<>((o1, o2) -> -1 * (o1.getValue() - o2.getValue()));

        for (String s : words) {
            if (dict.containsKey(s)) {
                dict.put(s, dict.get(s) + 1);
            } else {
                dict.put(s, 0);
            }
        }

        for (Map.Entry<String, Integer> e : dict.entrySet()) {
            reverseWords.add(e);
        }

        Set<String> out = new TreeSet<>();
        List<String> out2 = new ArrayList();
        int i = 0;

        for (Map.Entry<String, Integer> e : reverseWords) {
            if (i++ < k)
                out.add(e.getKey());
            else
                break;
        }

        out2.addAll(out);
        return out2;
    }
}
