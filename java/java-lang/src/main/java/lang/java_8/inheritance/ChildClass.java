package lang.java_8.inheritance;

public class ChildClass extends BaseClass {

    private boolean child;

    /**
     * @return the isChild
     */
    public boolean isChild() {

        return child;
    }

    /**
     * @param isChild the isChild to set
     */
    public void setChild(final boolean isChild) {

        child = isChild;
    }

    @Override
    protected BaseClass showProps() {

        final ChildClass obj = new ChildClass();

        obj.setChild(true);
        obj.setX(30);
        obj.setBool(false);
        obj.setStr("Child String");

        return obj;
    }
}
