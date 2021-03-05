package problemsolving.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrangeMaxEvents {

    public static void main(String[] args) {
        int[] arrival = {1, 3, 3, 5, 7};
        int[] duration = {2, 2, 1, 2, 1};

        System.out.println(maxEvents(arrival, duration));
    }

    public static int maxEvents(int[] arrivalArray, int[] durationArray) {

        int notScheduled = 0;
        int totalEvent = arrivalArray.length;
        int[][] interval = new int[totalEvent][2];

        for (int i = 0; i < totalEvent; i++) {
            interval[i] = new int[]{arrivalArray[i], arrivalArray[i] + durationArray[i]};
        }

        Arrays.sort(interval, Comparator.comparingInt(a -> a[1]));

        // the finish time of first event;
        int currentEntry = interval[0][1];

        for (int i = 1; i < totalEvent; i++) {
            int[] toSchedual = interval[i];
            if (toSchedual[0] < currentEntry)
                notScheduled++;
            else {
                currentEntry = toSchedual[1];
            }
        }
        return totalEvent - notScheduled;
    }

    public static int maxEvents3(int[] arrivals, int[] departures) {
        int[][] events = new int[arrivals.length][2];
        for (int i = 0; i < arrivals.length; i++) {
            events[i][0] = arrivals[i];
            events[i][1] = arrivals[i] + departures[i];
        }

        Arrays.sort(events, (a, b) -> (a[0] - b[0]));

        int totalEvents = 0;
        int currentEventEndTime = events[0][1];

        for (int i = 1; i < events.length - 1; i++) {
            if (currentEventEndTime <= events[i + 1][0]) {
                currentEventEndTime = events[i + 1][1];
                totalEvents++;
            }
        }
        return totalEvents + 1;
    }


    private static int maxEvents2(int[] arrival, int[] duration) {
        int[][] events = new int[arrival.length][2];
        for (int i = 0; i < arrival.length; i++) {
            events[i] = new int[]{arrival[i], arrival[i] + duration[i]};
        }
        // sort the events array by arrival time
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] first = events[0];
        for (int i = 1; i < events.length; i++) {
            int[] cur = events[i];
            if (cur[0] < first[1])
                minHeap.offer(cur);
            else {
                first[1] = events[i][1];
            }
        }
        return arrival.length - minHeap.size();
    }
}
