package problemsolving.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateFormatExample {

    public static void main(String[] args) {

        String s = "01-04-1989";
        String dateFormatString = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);

        try {
            System.out.println("Result: " + dateFormat.format(dateFormat.parse(s)));
        } catch (ParseException e) {
            System.out.println("Error date parsing: " + s + "in format " + dateFormatString);
            e.printStackTrace();
        }
    }
}
