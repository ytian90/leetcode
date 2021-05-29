package leetcode.uber;

import java.util.Arrays;

/**
 * 给一个array 需要查看 三个条件  1）a ^ 2 + a[i + 1] ^2 = a[i + 2] ^ 2
 *                              2）a ^ 2 + a[i + 2] ^2 = a[i + 1] ^ 2
 *                              3）a[i+1] ^ 2 + a[i + 2] ^2 = a[i] ^ 2
 * 如果满足上面三个条件就返回1 不然就是0， 返回类型是个 int array
 *     example： [1,2, 5, 5, 0]    返回   [1, 0, 1]
 */
public class ArrayThreeConditions {
    public static int[] calculate(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n - 2];
        for (int i = 2; i < n; i++) {
            if (Math.pow(nums[i - 2], 2) + Math.pow(nums[i - 1], 2) == Math.pow(nums[i], 2) ||
                Math.pow(nums[i - 2], 2) + Math.pow(nums[i], 2) == Math.pow(nums[i - 1], 2) ||
                Math.pow(nums[i - 1], 2) + Math.pow(nums[i], 2) == Math.pow(nums[i - 2], 2)) {
                res[i - 2] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculate(new int[]{1, 2, 5, 5, 0})));
    }

}
