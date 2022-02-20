package practice.javalang8;

public class ShiftCharactersInStringByOffset {

    public static void main(String[] args) {
        /*int i = 10;
        Integer j = new Integer(10);

        System.out.println(i == j);*/
        int y = -3;
        char a = 'a';
        char newa = 0;

        System.out.println("4324234".substring(1));
        if( y > 0) {
            if ((int) a + y <= 122) {
                newa = (char) ((int) a + y);
            } else {
                newa = (char) (96 + (int) a - 97);
//            if(a == 0) newa = (char) ((int)newa + 26);
            }
        }else {
            if((int) a -  Math.abs(y) <= 97)
                newa = (char) (96 + (122 - ((int)a+1)) );
            else
                newa = (char) ((int)a - Math.abs(y)) ;
        }

//        if(y > 26 ) y = y % 26;

//        char newa = (char)((int)a + y);
        System.out.println(a);
        System.out.println(y);
        System.out.println(newa);
    }
}
