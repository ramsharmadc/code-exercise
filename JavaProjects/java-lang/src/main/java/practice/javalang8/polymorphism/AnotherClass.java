package practice.javalang8.polymorphism;

public class AnotherClass extends StaticMethodsChild {

    AnotherClass(int e) {
        super(e);

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
    public String thisCanbeOverloaded(String arg) {

        // TODO Auto-generated method stub
        return "";
    }

}
