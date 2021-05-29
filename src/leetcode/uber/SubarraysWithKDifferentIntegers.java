package leetcode.uber;

/**
 * LC 992. Subarrays with K Different Integers
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findMostK(nums, k) - findMostK(nums, k - 1);
    }

    private int findMostK(int[] A, int k) {
        int i = 0, res = 0, n = A.length;
        int[] count = new int[n + 1];
        for (int j = 0; j < n; j++) {
            if (count[A[j]]++ == 0) {
                k--;
            }
            while (k < 0) {
                if (--count[A[i++]] == 0) {
                    k++;
                }
            }
            res += j - i + 1;
        }
        return res;
    }
}
