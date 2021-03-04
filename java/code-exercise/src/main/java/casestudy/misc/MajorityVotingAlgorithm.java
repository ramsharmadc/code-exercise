package casestudy.misc;

public class MajorityVotingAlgorithm {
    public static void main(String[] args) {
        String str = "AAACCBBBBBBBBBBBBBBCCCBCCCAAAACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCE";
        MajorityVotingAlgorithm obj = new MajorityVotingAlgorithm();
        char[] arr = str.toCharArray();
        int i = obj.giveMajorityElementIndex(arr);
        System.out.println(arr[i]);
    }

    public int giveMajorityElementIndex(char[] chars) {
        int count = 1;
        int majIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[majIndex] == chars[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }
        return majIndex;
    }
}
