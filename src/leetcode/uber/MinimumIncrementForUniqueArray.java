package leetcode.uber;

import java.util.Arrays;

public class MinimumIncrementForUniqueArray {
    public static int minIncrement(int[] nums) {
        int n = nums.length;
        int res = 0;
        if (n < 2) return 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minIncrement(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
