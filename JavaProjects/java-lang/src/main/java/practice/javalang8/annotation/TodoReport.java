package practice.javalang8.annotation;

import java.lang.reflect.Method;

public class TodoReport {
    public TodoReport() {
        super();
    }

    public static void main(String[] args) {
        getTodoReportForBusinessLogic();
    }

    /**
     * This method iterates through all messages of BusinessLogic class and fetches
     * annotations defined on each of them.
     * After that it displays the information from annotation accordingly.
     */
    private static void getTodoReportForBusinessLogic() {

        Package _Package = TodoReport.class.getPackage();
        System.out.println(_Package.getName());
        for (Package p : _Package.getPackages()) {
            System.out.println(p.getName());

        }
        Class businessLogicClass = BusinessLogic.class;
        for (Method method : businessLogicClass.getMethods()) {
            Todo todoAnnotation = (Todo) method.getAnnotation(Todo.class);
            if (todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
                System.out.println(" --------------------------- ");
            }
        }
    }
}
