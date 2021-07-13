package company.lnkin;

import java.util.Arrays;

/**
 * LC 611. Valid Triangle Number
 *
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 */
public class ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else l++;
            }
        }
        return count;
    }

    /**
     * Time: O(N ^ 2)
     * Space: O(1)
     */

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(triangleNumber(new int[]{4, 2, 3, 4}));
    }
    /**
     * some analysis and explanation:
     * our target is a+b>c, so there are two ways to implement 3 pointers method - suppose the three pointers are i, j and k, where i < j < k:
     * we fix the first pointer i and make j = i+1, k = n-1, if a[i]+a[j]>a[k], then there are k-j combinations that satisfy a+b>c.
     * however, if a[i]+a[j]<=a[k], based on the condition, we have two options: 1) j++, OR 2) k--
     * the problems will happen right here - if we are considering all the combinations - the solution is becoming O(N^3) again.
     * if we just simply move j, we are missing the cases where the third pointer between j and k
     */
}
