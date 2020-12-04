package leetcode.array;

import java.util.Arrays;

/**
 * Find the closest number pair, if have many, print all of these pair, use space to print
 * http://www.1point3acres.com/bbs/thread-143059-1-1.html
 * @author yutian
 * @since Jan 28, 2016
 */
public class FindClosestNumberPair {
	
	public static void find(int n, int[] nums) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			min = Math.min(min, nums[i] - nums[i - 1]);
		}
		for (int i = 1; i < n; i++) {
			if (nums[i] - nums[i - 1] == min) {
				System.out.print(nums[i - 1] + " " + nums[i] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		find(5, new int[]{1, 2, 4, 5, 6});
		find(5, new int[]{2, 1, 5, 8, 7});
	}

}
