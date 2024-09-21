package practice.javalang8;

public class PrintTriangle {

    public void printTriangle() {
        int spaces = 4;

        for (int i = 1; i < 5; i++) {

            for(int k = 0; k < spaces; k++){
                System.out.print(" ");
            }

            spaces--;

            for (int j = 0; j < i; j++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new PrintTriangle().printTriangle();
    }
}