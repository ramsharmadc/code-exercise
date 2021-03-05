package problemsolving.misc;

public class LargestAndSmallestNumberOneSectionAscendingAndOtherDescending {

    public static void main(String[] args) {
        int[] n = {10, 9, 8, 7, 2, 3, 4, 5, 6, 7};

        // if first section is ascending
        if (n[0] < n[1]) {// && n[0] < n[n.length - 1]) {

            int smallestNumber = n[0] < n[n.length - 1] ? n[0] : n[n.length - 1];
            int startOfDescendingSection = -1;

            for (int i = (n.length - 1); i > 0; i--) {
                if (n[i - 1] < n[i]) {// && n[i - 1] > n[i - 2]) {
                    startOfDescendingSection = i;
                    break;
                } else
                    continue;
            }
            System.out.format("Smallest number is %d ", smallestNumber);
            System.out.format("\nLargest number is %d", n[startOfDescendingSection]);
            return;
        }

        // if first section is descending
        if (n[0] > n[1]) {// && n[0] < n[n.length - 1]) {
            int startOfAscendingSection = -1;

            for (int i = (n.length - 1); i > 0; i--) {
                if (n[i - 1] > n[i]) {// && n[i - 1] > n[i - 2]) {
                    startOfAscendingSection = i;
                    break;
                } else
                    continue;
            }

            System.out.format("Largest number is %d", n[0]);
            System.out.format("\nSmallest number is %d ", n[startOfAscendingSection]);
            return;
        }
    }

}
