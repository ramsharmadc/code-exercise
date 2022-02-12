package practice.javalang8.clasz;

import java.util.Date;

public class TestImmutable extends Immutable {
    TestImmutable(final Date date) {
        super(date);
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("deprecation")
    public static void main(final String[] args) {
        final Immutable imObj = new Immutable(new Date("09/06/2013"));
        final Immutable imObj2 = imObj;
        System.out.println(imObj2.getDate());
        imObj.getDate().setYear(12);
        System.out.println(imObj2.getDate());
    }
}
