package casestudy.misc;

public class SampleArray {

    public static void main(String[] args) {

        String[] strArr = {"Array ", "Is ", "Powerfull"};
        int[] willExtend = new int[10];

        System.out.println(makeSentence(strArr));

        willExtend[0] = 10;
        willExtend[1] = 20;
        willExtend[2] = 30;
    }

    private static String makeSentence(String[] words) {

        StringBuffer strBuff = new StringBuffer();

        for (String s : words)
            strBuff.append(s);

        return strBuff.toString();
    }
}
