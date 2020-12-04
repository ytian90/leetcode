package leetcode.binarySearch;

/**
 * 1283. Find the Smallest Divisor Given a Threshold
 */
public class FindTheSmallestDivisorGivenAThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int n : nums) {
                count += (n + mid - 1) / mid;
            }
            if (count > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(smallestDivisor(new int[]{19}, 5));
    }
}
