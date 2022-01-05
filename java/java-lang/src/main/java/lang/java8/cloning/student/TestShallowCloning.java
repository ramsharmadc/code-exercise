package lang.java8.cloning.student;

/**
 * Created by lenovo on 4/19/2014.
 */
public class TestShallowCloning {

    public static void main(final String[] args) {

        final Subject sub = new Subject("Physics");
        final Student originalStudent = new Student("John", sub);
        System.out.println(originalStudent);

        Student clonedStudent = null;
        try {
            // cloning originalStudent
            clonedStudent = (Student) originalStudent.clone();
            System.out.println(clonedStudent);
        } catch (final Exception e) {
            e.printStackTrace();
        }

        // changing subject of cloned student
        System.out.println("\n changing cloned student");

        clonedStudent.setName("DAN");
        clonedStudent.getSubject().setName("Maths");

        System.out.println(originalStudent);
        System.out.println(clonedStudent);

        // changing original student
        System.out.println("\n changing original student");
        originalStudent.setName("DANNY");
        originalStudent.getSubject().setName("Chemistry");

        System.out.println(originalStudent);
        System.out.println(clonedStudent);
    }
}
