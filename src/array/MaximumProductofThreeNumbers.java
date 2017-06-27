package array;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 * @author ytian
 *
 */
public class MaximumProductofThreeNumbers {
	
	public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[0] * nums[1] * nums[n - 1];
        return a > b ? a : b;
    }

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[]{1, 2, 3}));
		System.out.println(maximumProduct(new int[]{1, 2, 3, 4}));
	}

}
