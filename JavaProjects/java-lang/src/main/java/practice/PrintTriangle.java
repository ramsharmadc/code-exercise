package practice;

public class PrintTriangle {

    public void printTriangle() {
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new PrintTriangle().printTriangle();
    }
}