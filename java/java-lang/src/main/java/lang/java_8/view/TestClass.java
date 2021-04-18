package lang.java_8.view;

import java.lang.reflect.InvocationTargetException;

public class TestClass {

    public static void main(final String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {

        final ClassForView classObj = new ClassForView(12, "Ram Sharma");
        new ViewForClass(classObj.getClass());

        // System.out.println(view.getId());
        // System.out.println(view.getName());
    }
}
