package dynamicProgramming;

import java.util.ArrayList;

/**
 * 198. House Robber
 * @author yutian
 * @since Aug 4, 2015
 */
public class HouseRobber {
	
	public static void main(String[] args) {
		System.out.println(rob(new int[]{3, 2, 0, 2, 3, 1, 2}));
		System.out.println(rob(new int[]{2, 1}));
		System.out.println(rob(new int[]{1, 3, 1}));
		System.out.println(rob(new int[]{}));
		System.out.println(rob(new int[]{0}));
		System.out.println(rob(new int[]{1, 2, 3, 1}));
		System.out.println(rob(new int[]{2, 1, 1, 2}));
	}
	
	// Solution 0
	public static int rob(int[] nums) {
		int rob = 0, noRob = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = noRob;
			// if not rob ith house, take the max value of robbed (i - 1)th house
			// and not rob (i - 1)th house
			noRob = Math.max(rob, noRob);
			// if rob current house, previous house must not be robbed
			rob = temp + nums[i];
		}
		return Math.max(rob, noRob);
	}
	
	// Solution 2
	public static int rob2(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		if (n == 1) return nums[0];
		int[] d = new int[n + 1];
		d[1] = nums[0];
		d[2] = nums[1];
		for (int i = 3; i <= n; i++) {
			d[i] = Math.max(d[i - 2], d[i - 3]) + nums[i - 1];
		}
		return Math.max(d[n - 1], d[n]);
	}
	

	// Solution 1
	public static int rob1(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		if (n == 1) return nums[0];
		if (n == 2) return Math.max(nums[0], nums[1]);
		int a = 0, b = nums[0], c = nums[1], r = 0;
		for (int i = 3; i <= n; i++) {
			r = Math.max(a, b) + nums[i - 1];
			a = b; b = c; c = r;
		}
		return Math.max(b, c);
	}
}
