package casestudy.misc;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private static List<Box> boxInsideList = new ArrayList<>();
    private static int count = 1;

    private static int countBoxes(final Box b) {
        List<Box> sub_boxes = b.getBoxInsideList();

        if (sub_boxes == null) {
            return 0;
        }

        if (sub_boxes != null) {
            for (final Box box : sub_boxes) {
                count += 1;
                if (b != null) {
                    countBoxes(box);
                }
            }
        }
        return count;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Box b1 = new Box();
        final Box b2 = new Box();
        final Box b3 = new Box();
        final Box b4 = new Box();
        final Box b5 = new Box();
        final Box b6 = new Box();
        final Box b7 = new Box();
        final Box b8 = new Box();

        b4.addBox(b5);
        b4.addBox(b6);
        b3.addBox(b7);
        b3.addBox(b8);
        b2.addBox(b3);
        b2.addBox(b4);
        b1.addBox(b2);

        System.out.println(countBoxes(b2));
    }

    public void addBox(final Box b) {
        getBoxInsideList().add(b);
    }

    public List<Box> getBoxInsideList() {
        return boxInsideList;
    }

    public void setBoxInsideList(final List<Box> boxInsideList) {
        Box.boxInsideList = boxInsideList;
    }
}
