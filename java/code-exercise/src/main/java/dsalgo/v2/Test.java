package dsalgo.v2;

/**
 * Created by ramsh on 08-05-2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        LinkList l = new LinkList();
        int i = 1000;
        System.out.println("Adding ~" + (1 << 10) + " values.");
        while (i <= (1 << 10)) {
            // System.out.println("adding " + i);
            l.add(i++);
        }
        l.iterate();
        // l.delete(1000);
        l.delete(1021);
        l.iterate();
    }
}
