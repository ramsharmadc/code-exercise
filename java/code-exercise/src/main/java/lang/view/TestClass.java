package lang.view;

import java.lang.reflect.InvocationTargetException;

public class TestClass {

	public static void main(final String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		final lang.view.ClassForView classObj = new lang.view.ClassForView(12, "Ram Sharma");
		new ViewForClass(classObj.getClass());

		// System.out.println(view.getId());
		// System.out.println(view.getName());
	}
}
