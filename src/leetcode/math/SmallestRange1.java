package leetcode.math;

/**
 * 908. Smallest Range I
 */
public class SmallestRange1 {

    public static int smallestRangeI(int[] A, int K) {
        int max = A[0], min = A[0];
        for (int n : A) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        return Math.max(0, max - min - 2 * K);
    }

    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{1}, 0));
        System.out.println(smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
