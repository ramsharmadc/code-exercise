package dsa.problemsolving.misc;

import java.util.HashSet;
import java.util.Set;

public class CheckStringsinSet {

    public static void main(String[] args) {

        String s = "Ram";
        String s2 = "Ram";
        String s3 = "Ram";

        Set<String> set = new HashSet<>();

        System.out.println("First adding s : " + set.add(s));
        System.out.println("Now adding s2 : " + set.add(s2));
        System.out.println("Now adding s3 : " + set.add(s3));
        System.out.println("Now adding Ram : " + set.add("Ram"));

        System.out.println(set.size());

    }
}
