package problemsolving.misc;

public class FindMissingNumberFromSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 9};
        int missingNumber = findMissing(arr);
        System.out.println(missingNumber);
    }

    private static int findMissing(int[] arr) {
        int n = arr[arr.length - 1];
        int sumShouldBe = (n * (n + 1)) / 2;
        int sumActually = addAll(arr);
        return sumShouldBe - sumActually;
    }

    private static int addAll(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }
}
