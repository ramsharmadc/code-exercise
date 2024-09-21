package dsa.techprep.searching;

public class BinarySearch {

    public static int search(int[] a, int item, int low, int high) {

        if (low == high) return -1;

        int mid = (int) Math.ceil(low + high / 2);
        if (a[mid] == item) return mid;
        if (item > a[mid]) return search(a, item, mid, high);
        if (item < a[mid]) return search(a, item, low, mid);
        else return -1;
    }
}
