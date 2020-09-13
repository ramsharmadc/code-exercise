package lang.jdk8.basics.cloning.student;

public class TestDeepCloning {

	public static void main(final String srgs[]) {
		try {
			final Subject sub = new Subject("Physics");
			final Student originalStudent = new Student("Johnny", sub);

			// cloning original student
			System.out.println("cloning original student");
			final Student clonedStudent = (Student) originalStudent.deepClone();
			System.out.println(originalStudent);
			System.out.println(clonedStudent);

			// changing subject of cloned student
			System.out.println("\n changing subject of cloned student");
			clonedStudent.getSubject().setName("Maths");
			System.out.println(originalStudent);
			System.out.println(clonedStudent);

			// changing subject original student
			System.out.println("\n changing subject original student");
			originalStudent.getSubject().setName("Chemistry");
			System.out.println(originalStudent);
			System.out.println(clonedStudent);

		} catch (final Exception e) {

		}
	}
}
