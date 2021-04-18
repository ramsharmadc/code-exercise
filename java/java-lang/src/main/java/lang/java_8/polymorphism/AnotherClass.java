package lang.java_8.polymorphism;

public class AnotherClass extends StaticMethodsChild {

    AnotherClass(int e) {

        super(e);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String evenThis(StaticMethodsParent obj) {

        // TODO Auto-generated method stub
        return super.evenThis(obj);
    }

    @Override
    public StaticMethodsParent thisAlo() {

        // TODO Auto-generated method stub
        return new StaticMethodsParent();
    }

    @Override
    public String thisCanbeOverloaded() {

        // TODO Auto-generated method stub
        return "";
    }

}
