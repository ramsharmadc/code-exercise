package lang.jdk8.basics.interfaces;

import java.util.Collection;
import java.util.Iterator;

public class UsingInterfaces extends AbstractClass implements SampleInterface {

    @Override
    public boolean add(String e) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {

        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(String o) {

        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(Object o) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<String> iterator() {

        // TODO Auto-generated method stub
        return null;
    }

    public void methodClass() {

        System.out.println("\nThis is in Class own method");
        SampleInterface siObj; // can't instantiate an interface object, just we
        // can create a reference;
        siObj = new UsingInterfaces(); // giving reference of UsingInterfaces
        // Class
        siObj.methodOne(213, "Sharad Sadolikar");
        siObj.methodTwo("PINK");

    }

    @Override
    public void methodOne(int ID, String Name) {

        // TODO Auto-generated method stub

        System.out.println("--This is in method One of the interface--");
        System.out
                .println("The Details are given below : \n [ID- " + ID + ", Name- " + Name + " ]");
    }

    @Override
    protected int methodOneofAbsCls(int pararm1) {

        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int methodOneofAbsCls(int pararm1, int param2) {

        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void methodTwo(String colour) {

        // TODO Auto-generated method stub
        System.out.println("\n--This is in method two of the interface--");
        System.out.println("The colour you mentioned is : " + colour);
    }

    @Override
    public boolean remove(Object o) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {

        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object[] toArray() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        // TODO Auto-generated method stub
        return null;
    }
}
