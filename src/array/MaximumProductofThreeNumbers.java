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
        int n = nums.length - 1;
        int a = nums[n] * nums[n - 1] * nums[n - 2];
        int b = nums[0] * nums[1] * nums[n];
        return a > b ? a : b;
    }

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[]{1, 2, 3}));
		System.out.println(maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(maximumProduct(new int[]{-4 ,-3, -2 ,-1, 60}));
	}

}
