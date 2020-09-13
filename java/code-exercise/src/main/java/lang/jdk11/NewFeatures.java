package lang.jdk11;

import java.util.Collections;
import java.util.List;


public class NewFeatures {

    public static void main(String[] args) {
        int a = 10;

        String b = "Streeeng";
        System.out.println(b);

        List l = Collections.singletonList(a);

        System.out.println(l);
        System.out.println(l.getClass());

    }
}
