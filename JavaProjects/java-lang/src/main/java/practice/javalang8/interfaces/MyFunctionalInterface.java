package practice.javalang8.interfaces;

import java.util.function.Function;

@FunctionalInterface
public interface MyFunctionalInterface extends Function {

    @Override
    Object apply(Object o) throws NumberFormatException;
}
