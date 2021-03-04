package lang.jdk8.basics.exception;

public class ReturnInTryAndFinally {

    public static void main(String[] args) {

        try {

            System.out.println("In try block..");
            return;
        } catch (Exception e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("Still in Finally");
        }
    }
}
