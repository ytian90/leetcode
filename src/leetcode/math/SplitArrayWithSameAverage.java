package leetcode.math;

import java.util.Arrays;

/**
 * 805. Split Array with Same Average
 */
public class SplitArrayWithSameAverage {

    public static boolean splitArraySameAverage(int[] A) {
        int n = A.length, sum = Arrays.stream(A).sum();
        for (int i = 1; i < n / 2 + 1; i++) {
            if (i * sum % n == 0 && find(A, i * sum / n, i, 0))
                return true;
        }
        return false;
    }

    private static boolean find(int[] A, int target, int k, int i) {
        if (k == 0) return target == 0;
        if (k + i > A.length) return false;
        return find(A, target - A[i], k - 1, i + 1) || find(A, target, k, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

}
