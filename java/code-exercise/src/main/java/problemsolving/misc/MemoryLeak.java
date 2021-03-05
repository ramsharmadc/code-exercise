package problemsolving.misc;

public class MemoryLeak {

    private static String str;

    public static void main(final String[] args) {

        while (true) {
            str = "";
        }
    }
}
