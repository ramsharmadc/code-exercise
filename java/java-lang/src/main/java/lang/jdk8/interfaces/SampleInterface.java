package lang.jdk8.interfaces;

import java.util.Collection;

public interface SampleInterface extends Collection<String>, Comparable<String> {

    String COLOUR = "RED";
    String NAME = "CIRCLE";
    String privateStr = "newPrivateString";

    void methodOne(int ID, String Name);

    void methodTwo(String colour);
}
