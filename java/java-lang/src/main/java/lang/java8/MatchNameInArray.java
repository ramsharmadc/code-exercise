package lang.java8;

import java.util.Scanner;

public class MatchNameInArray {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        // String name = s.nextLine(); // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");

        int c = -1, m = 0, n = 0;
        int[][] arr = new int[0][];
        while (s.hasNext()) {
            String st = s.nextLine();
            System.out.println(st);
            if (c == -1) {
                String[] ar = st.split(" ");
                m = Integer.parseInt(ar[0].trim());
                n = Integer.parseInt(ar[1].trim());
                arr = new int[m][n];
                c += 1;
            } else {
                int j = 0;
                for (; j < st.length(); j++) {
                    arr[c][j] = st.charAt(j);
                }
                c += 1;
            }
            if (c == m)
                break;
        }

        System.out.println(arr);
    }
}
