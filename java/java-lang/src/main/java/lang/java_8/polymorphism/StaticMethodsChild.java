package lang.java_8.polymorphism;

public class StaticMethodsChild extends StaticMethodsParent {

    int r = 1;

    StaticMethodsChild(int e) {

        r = e;
        System.out.println("child class :: " + r);
    }

    public static String getString() {

        return "StaticMethodsChild class";
    }

    public String evenThis(StaticMethodsParent obj) {

        return "StaticMethodChild";
    }

    public int getNumber() {

        return 0;
    }

    @Override
    public Object getNumberFrom() {

        // TODO Auto-generated method stub
        System.out.println("Child class method---" + r);
        return r;
    }

    public Parent thisAlo() {

        return new StaticMethodsParent();
    }

    public Object thisCanbeOverloaded() {

        // TODO Auto-generated method stub

        return "";

    }
}
