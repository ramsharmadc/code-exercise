package dsa.problemsolving.misc;

import java.util.*;

public class GetDirectOrIndirectReporteesGraph {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> l = new HashMap<>();
        l.put(1, Arrays.asList(2, 3, 4));
        l.put(3, Arrays.asList(5, 6, 7));
        l.put(5, Arrays.asList(8, 9, 10));

        findReportees(3, l);
    }

    private static void findReportees(int i, Map<Integer, List<Integer>> l) {
        List<Integer> alltheReportees = new ArrayList<>();
        findReportees(i, l, alltheReportees);
        for (Integer k : alltheReportees) {
            System.out.println(k);
        }
    }

    private static void findReportees(int i, Map<Integer, List<Integer>> l, List<Integer> alltheReportees) {
        if (l.get(i) == null) return;
        for (Integer k : l.get(i)) {
            alltheReportees.add(k);
            findReportees(k, l, alltheReportees);
        }
    }
}
