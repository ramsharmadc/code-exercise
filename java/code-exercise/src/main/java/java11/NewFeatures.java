package java11;

import java.util.Collections;
import java.util.List;


public class NewFeatures {

    public static void main(String[] args) {
        int a = 10;
//        var b = "String";

//        System.out.println(b);

        List l = Collections.singletonList(a);

        System.out.println(l);
        System.out.println(l.getClass());

    }
}
