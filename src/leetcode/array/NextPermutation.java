package leetcode.array;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * @author yutian
 * @since Aug 18, 2015
 */
public class NextPermutation {
	// Time: O(N), Space: O(1)
	// from right to left, find the longest descending tail and reverse it to make 
	// ascending order, then from left to right, find the first number greater than
	// partition number(curr - 1), swap it.
	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int n = nums.length - 1, i = n;
		while (i > 0 && nums[i - 1] >= nums[i]) {
			i--;
		}
		reverse(nums, i, n);
		// swap num[curr - 1] and the first integer element on its right side
		if (i > 0) {
			int j = i;
			i--;
			while (nums[i] >= nums[j]) j++;
			swap(nums, i, j);
		}
	}

	private static void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		int[] t = new int[]{1, 2, 3};
		for (int i = 0; i < 10; i++) {
			nextPermutation(t);
			System.out.println(Arrays.toString(t));
		}
		System.out.println();
		int[] t2 = new int[]{1, 1, 5};
		nextPermutation(t2);
		System.out.println(Arrays.toString(t2));
	}
	
}
