package company.uuba;

/**
 * LC 977. Squares of a Sorted Array
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int i = 0, j = n - 1, pos = n - 1;
        int[] res = new int[n];
        while (i <= j) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[pos--] = (int) Math.pow(nums[j--], 2);
            } else {
                res[pos--] = (int) Math.pow(nums[i++], 2);
            }
        }
        return res;
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */
}
