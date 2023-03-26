package practice.javalang8.annotation;

@SimpleAnnotation(Id = "Id123", Name = "IdentityName", Type = "IdentityType")
public class SimpleClass {

    //@SimpleAnnotation(Id = "Id123", Name = "IdentityName", Type = "IdentityType")
    static String hello;

    public static void main(String[] args) {
        System.out.println(new SimpleClass());

        StringBuffer stringBuffer = new StringBuffer("Thread safe String Buffer");

        StringBuilder stringBuilder = new StringBuilder("Not Threadsafe String Builder");

    }
}
