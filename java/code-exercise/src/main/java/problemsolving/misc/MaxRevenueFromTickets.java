package problemsolving.misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxRevenueFromTickets {
    static int[] tickets = {5, 1, 7, 10, 11, 9};

    public static void main(String[] args) {
        int rev = getMaxRevenue(tickets, 50);
        System.out.println(rev);
    }

    private static int getMaxRevenue(int[] tickets, int toBeSold) {
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int totalRevenue = 0;

        for (int i = 0; i < tickets.length; i++) {
            heap.offer(tickets[i]);
        }

        while (toBeSold-- > 0) {

            int next = heap.poll();
            totalRevenue += next;
            heap.offer(--next);
        }

        return totalRevenue;
    }
}
