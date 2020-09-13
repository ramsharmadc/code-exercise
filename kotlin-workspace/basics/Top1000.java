package hello;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;


/**
 * /**
 * * Service which returns top (with maximum value) 1000 elements from endless data source of incoming elements.
 * * <p>
 * * P.S. Declarations of methods could be change accordingly without changing their names.
 */

/**
 * * Would be called in case of incoming element. One incoming element would be passed as argument
 **/

public class Top1000<T> {

    private int MAX_SIZE = 5;

    private Queue<T> dataStorage = new PriorityBlockingQueue<>(MAX_SIZE, new MyComparator());

    public void onEvent(T a) {
        if (a != null) {
            if (dataStorage.size() >= MAX_SIZE) {
                dataStorage.remove(); // todo fix
            }
            dataStorage.add(a);
        } else {
            // todo handle invalid scenario
        }
    }

    /**
     * * Returns top (with maximum value) 1000 elements. Could be called anytime.
     */
    // [1, 2, 3, 4, 5,6] -> out [4,5,6]
    // in [ 5, 3, 2, 1, 4] -> out [3,4,5]
    public List<Integer> getTop(int n) {

        List<Integer> maxList = new ArrayList<>(n);

        synchronized (dataStorage) {

            while (dataStorage.size() >= n) {
                try {
                    dataStorage.wait(10);
                } catch (InterruptedException e) {
                    System.out.println("Error while fetching numbers");
                } /*finally {
                    dataStorage.notifyAll();
                }*/
            }

            dataStorage.notifyAll();
        }

        for (int i = 0; i < dataStorage.size(); i++) {
            if (i >= n) break;
            int top = (Integer) dataStorage.poll();
            System.out.println(top);
            maxList.add(top);
        }

//        maxList.forEach(x -> System.out.println(x));
        return maxList;
    }

    private class MyComparator implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {

            if (!(o1 instanceof Comparable) || !(o2 instanceof Comparable))
                try {
                    throw new Exception("Can not compare");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;

            return c2.compareTo(c1);
        }
    }

    public static void main(String[] args) {
        Top1000<Integer> top1000 = new Top1000<>();
        top1000.onEvent(3);
        top1000.onEvent(6);
        top1000.onEvent(2);
        top1000.onEvent(4);
        top1000.onEvent(5);
        top1000.onEvent(7);

        top1000.getTop(5);
    }
}


