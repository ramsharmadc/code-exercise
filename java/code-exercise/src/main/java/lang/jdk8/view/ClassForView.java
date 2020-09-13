package lang.jdk8.view;

public class ClassForView {

	static int id;
	static StringBuilder name = new StringBuilder();

	public ClassForView(int i, String str) {

		ClassForView.id = i;
		ClassForView.name.append(str);
	}

	public static int getId() {

		return id;
	}

	public static void setId(int id) {

		ClassForView.id = id;
	}

	public static String getName() {

		return name.toString();
	}

	public static void setName(StringBuilder name) {

		ClassForView.name = name;
	}
}
