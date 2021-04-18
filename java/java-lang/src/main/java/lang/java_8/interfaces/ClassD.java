package lang.java_8.interfaces;

import lang.java_8.inheritance.ClassB;

public class ClassD {

    ClassB b;

    public static void main(String[] args) {
        ClassD d = new ClassD();
        // d.m(null,null);
    }

    void helper() {
        // b.met1OfA();
        // System.out.println(b.x);
    }

    void m(Object a, Object b) {
        System.out.println("m(Object a, Object b)");
    }

    void m(String a, String b) {
        System.out.println("m(String a, String b)");
    }

    void m(Integer a, Integer b) {
        System.out.println("m(Integer a, Integer b)");
    }
}
