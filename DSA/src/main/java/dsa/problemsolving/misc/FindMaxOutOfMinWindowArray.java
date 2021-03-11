package dsa.problemsolving.misc;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaxOutOfMinWindowArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        int k = 1;
        int max = findMaxInMinWindow(arr, k);
        System.out.println(max);

        int[] arr2 = {1, 1, 1};
        k = 2;
        max = findMaxInMinWindow(arr2, k);
        System.out.println(max);
    }

    public static int findMaxInMinWindow(int[] arr, int k) {

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> auxQueue = new ArrayDeque<>();

        int[] resultArr = new int[(arr.length - k) + 1];

        int maxElement = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            queue.add(arr[i]);

            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }

            if (auxQueue.size() > 0) {
                if (arr[i] < auxQueue.peek()) {
                    auxQueue.push(arr[i]);
                } else {
                    while (auxQueue.size() > 0 && (arr[i] > auxQueue.peek())) {
                        auxQueue.pollLast();
                    }

                    auxQueue.push(arr[i]);
                }
            } else {
                auxQueue.push(arr[i]);
            }

            if (queue.size() > 3) {
                int removedEl = queue.removeFirst();
                if (maxElement == removedEl) {
                    maxElement = auxQueue.pollFirst();
                }
            }

            if (queue.size() == 3) {
                resultArr[j++] = maxElement;
            }

        }

        return resultArr[0];
    }
}
