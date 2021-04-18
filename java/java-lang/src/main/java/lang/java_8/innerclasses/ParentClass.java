package lang.java_8.innerclasses;

public class ParentClass {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Inner1 innObj1 = new ParentClass().new Inner1();

        ParentClass obj = new ParentClass();
        obj.nonStaticMethod();

        ParentClass2.InnerClass1 inObj = new ParentClass2().new InnerClass1();
        inObj.print();
    }

    public void nonStaticMethod() {

        Inner1 innObj1 = new Inner1();
        Inner2 innObj2 = new Inner2();

        System.out.println(innObj1.getI());
        System.out.println(innObj2.getI());
    }

    class Inner1 {

        private final int i = 10;

        public int getI() {

            return i;
        }
    }

    class Inner2 {

        private final int i = 20;

        // static public int j = 30;
        public int getI() {

            return i;
        }
    }
}
