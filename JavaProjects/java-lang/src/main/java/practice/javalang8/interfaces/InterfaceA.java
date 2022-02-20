package practice.javalang8.interfaces;

@FunctionalInterface
public interface InterfaceA {

    String methodOne(String str);

    default String methodTwo() {
        return "";
    }

    static void interfaceAsPrivate() {
    }
}
