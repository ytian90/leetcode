package leetcode.mj.airbnb;

/**
 * 9. Find Median in Large File of Integers
 */
public class FindMedianInLargeFileOfIntegers {

    private long search(int[] nums, int k, long left, long right) {
        if (left >= right)
            return left;

        long res = left;
        long guess = left + (right - left) / 2;
        int count = 0;
        for (int n : nums) {
            if (n <= guess) {
                count++;
                res = Math.max(res, n);
            }
        }

        if (count == k)
            return res;
        else if (count < k)
            return search(nums, k, Math.max(res + 1, guess), right); // ? why max
        else
            return search(nums, k, left, res);
    }

    public double findMedian(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return (double) search(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            return ((double) search(nums, n / 2, Integer.MIN_VALUE, Integer.MAX_VALUE)
                + (double) search(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) / 2;
        }
    }
}
