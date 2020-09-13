package lang.jdk8.view;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewForClass {

	private static Class<?> clazz;

	private int id;

	private StringBuilder name;

	public ViewForClass() {

		// clazz = null;
		name = new StringBuilder();
	}

	public ViewForClass(Class<?> clazz) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		this();
		ViewForClass.clazz = clazz;

		Field[] allFields = this.collectProperties();

		for (Field field : allFields) {
			System.out.println(field.getName());

			Method m = ViewForClass.clazz.getClass()
					.getMethod("get" + field.getName());
			m.invoke(ViewForClass.clazz);
		}
	}

	private Field[] collectProperties() {

		Field[] allFields = ViewForClass.clazz.getDeclaredFields();
		return allFields;
	}

	public int getId() {

		return id;
	}

	public void setId(Object object) {

		this.id = (int) object;
	}

	public String getName() {

		return name.toString();
	}

	public void setName(Object invoke) {

		this.name.append((String) invoke);
	}
}
