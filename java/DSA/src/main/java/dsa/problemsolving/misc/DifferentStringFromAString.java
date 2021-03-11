package dsa.problemsolving.misc;

import java.util.Set;
import java.util.TreeSet;

public class DifferentStringFromAString {

    // brute force
    public static void main(String[] args) throws Exception {
        char[] str = {'a', 'b', 'c', 'd'};
        // int str[] = {1, 2, 3};
        Set<String> set = new TreeSet<String>();
        // List<String> list = new LinkedList<String>();

        for (int i = 0; i < str.length; i++) {

            StringBuffer strB = new StringBuffer();
            strB.append(str[i]);
            set.add(strB.toString());
            // list.add( strB.toString() );

            for (int j = 0; j < str.length; j++) {

                if (!(str[i] == str[j])) {

                    strB.append(str[j]);
                }

                set.add(strB.toString());

                // list.add( strB.toString() );
            }
        }

        System.out.println(set);
        // System.out.println( list );
    }
}
