package lang.java8.inheritance;

public class BaseClass {

    private int x;
    private String str;
    private boolean bool;

    /**
     * @return the str
     */
    public String getStr() {

        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(final String str) {

        this.str = str;
    }

    /**
     * @return the x
     */
    public int getX() {

        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(final int x) {

        this.x = x;
    }

    /**
     * @return the bool
     */
    public boolean isBool() {
        return bool;
    }

    public void setBool(final boolean bool) {
        this.bool = bool;
    }

    protected BaseClass showProps() {
        final BaseClass obj = new BaseClass();
        obj.setBool(true);
        obj.setStr("Hello");
        obj.setX(20);

        return obj;
    }

    @Override
    public String toString() {
        return "[ X = " + getX() + ", String = " + getStr() + ", Boolean = " + isBool() + "]";
    }
}
