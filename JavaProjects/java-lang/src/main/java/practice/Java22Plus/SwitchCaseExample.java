package practice.Java22Plus;

public class SwitchCaseExample {
    public static void main(String[] args) {
        Object obj = 10L;

        checkSwitchCaseForObject(obj);
    }

    private static void checkSwitchCaseForObject(Object obj) {
        int newVar = 12; // unnamed variable
        
        switch (obj){
            default:
                throw new IllegalStateException("Unexpected value: " + obj);
        }
    }

}
