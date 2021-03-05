package lang.jdk8.basics.reflection;

// import problem.misc.ReverseNumber;

import problemsolving.misc.ReverseNumber;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionsExample {

    /**
     * @param args
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void main(String[] args)
            throws IllegalArgumentException, SecurityException, IllegalAccessException,
            NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        ReverseNumber c = new ReverseNumber();

        c.getClass().getField("n").setInt(c, 208);

        System.out.println(c.getClass().getField("n").getInt(c));

        System.out.println(c.getClass().getMethod("reverse",
                int.class).invoke(c, 208));

        Method m = c.getClass().getMethod("reverse", int.class);

        System.out.println(m.invoke(c, 209));
    }
}
