package dsa.problemsolving.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairsForGivenSum {

    public static void main(String[] args) {

        int[] a = {33, 22, 11, 9, 8, 10, 7};
        int sum = 17;

        Set<Pair> p = findPair(sum, a);
        System.out.println(p.size());
        p.forEach(x -> System.out.println(x));

    }

    private static Set<Pair> findPair(int sum, int[] a) {

        Map<Integer, Integer> mem = new HashMap<>();
        Set<Pair> pairs = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            mem.put(a[i], i);
        }

        for (int i = 0; i < a.length; i++) {
            if (mem.containsKey(sum - a[i])) {
                Pair p = new Pair(sum - a[i], a[i]);
                pairs.add(p);
            }
        }
        return pairs;
    }

    private static void accept(Pair x) {
        System.out.println();
    }

    static class Pair {
        Integer a;
        Integer b;

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + a +
                    ", j=" + b +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Pair)) return false;

            Pair thisPair = (Pair) o;

            return (a.equals(thisPair.a) && b.equals(thisPair.b)) ||
                    a.equals(thisPair.b) && b.equals(thisPair.a);
        }

        @Override
        public int hashCode() {
            return a * b * 31;
        }
    }
}
