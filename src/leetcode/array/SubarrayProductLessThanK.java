package leetcode.array;

/**
 * 713. Subarray Product Less Than K
 */
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return 0;
        int res = 0, prod = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
