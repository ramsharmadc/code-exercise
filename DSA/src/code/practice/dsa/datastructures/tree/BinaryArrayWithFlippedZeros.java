package dsa.datastructures.tree;

public class BinaryArrayWithFlippedZeros {

    static int start_index = -1;
    static int end_index = -1;

    static void findZeroAndFlip(int[] binary_array, int array_length, int k) {

        int window_left = 0;
        int window_right = 0;
        int best_left_index = 0;
        int size_of_best_window = 0;
        int count_of_zero = 0;

        // While right boundary within limits
        while (window_right < array_length) {
            // zero_count of current window is less than m,
            // widen the window toward right
            if (count_of_zero <= k) {
                if (binary_array[window_right] == 0)
                    count_of_zero++;
                window_right++;
            }

            // zero_count of current window is more than m,
            // reduce the window from left
            if (count_of_zero > k) {
                if (binary_array[window_left] == 0)
                    count_of_zero--;
                window_left++;
            }

            // update widest window if this window size is more
            if (window_right - window_left > size_of_best_window) {
                size_of_best_window = window_right - window_left;
                best_left_index = window_left;
            }
        }

        // collect positions of zeroes in the widest window
        int flag = 0;
        for (int i = 0; i < size_of_best_window; i++) {
            if (binary_array[best_left_index + i] == 0) {

                if (flag == 0) {
                    start_index = best_left_index + i;
                    flag = 1;
                } else
                    end_index = best_left_index + i;
            }
        }
    }

    // test program
    public static void main(String[] args) {

        int[] binary_array = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int flip_limit = 2;
        int array_length = binary_array.length;

        findZeroAndFlip(binary_array, array_length, flip_limit);
        System.out.println("Start Index: " + start_index);
        System.out.println("End Index:  " + end_index);
    }
}
