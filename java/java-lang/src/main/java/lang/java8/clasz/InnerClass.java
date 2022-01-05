package lang.java8.clasz;

public class InnerClass {

    private static final String s = "Hello";
    private InnerClass.ThisIsInnerClass o = new ThisIsInnerClass();

    public InnerClass.ThisIsInnerClass getO() {

        return o;
    }

    public void setO(InnerClass.ThisIsInnerClass o) {

        this.o = o;
    }

    static class Entry {
        // for static nested class, static variable is fine
        static int i = 0;

    }

    class ThisIsInnerClass {

        // static blocks not allowed
        // static {
        // }

        // static members not allowed, only FINAL static
        static final int n = 0;

        public void callingInner() {
            System.out.println(n);
            System.out.println(s);
        }
    }
}
