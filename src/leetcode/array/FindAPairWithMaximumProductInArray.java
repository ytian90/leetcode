package leetcode.array;

import java.util.Arrays;

/**
 * Find a pair with maximum product in leetcode.array of integers
 * http://www.geeksforgeeks.org/return-a-pair-with-maximum-product-in-array-of-integers/
 * @author yutian
 * @since Jan 12, 2016
 */
public class FindAPairWithMaximumProductInArray {
	
	public static int MaxProduct0(int[] nums) {
		if (nums == null || nums.length < 2) return Integer.MIN_VALUE;
		int max = nums[0] * nums[1];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				Math.max(max, nums[i] * nums[j]);
			}
		}
		return max;
	}
	
	public static int MaxProduct(int[] nums) {
		if (nums == null || nums.length < 2) return Integer.MIN_VALUE;
		int maxEndHere = nums[0] * nums[1], max = maxEndHere, maxNum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > maxNum) {
				maxEndHere = Math.max(maxEndHere, maxNum * nums[i]);
				maxNum = nums[i];
			}
			max = Math.max(maxEndHere, max);
		}
		return max;
	}
	
	// brute force Time ~O(N) Space ~O(1)
	public static int[] MaxProduct1(int[] nums) {
		if (nums == null || nums.length < 2) return null;
		int[] result = new int[]{nums[0], nums[1]};
		int max = result[0] * result[1];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] * nums[j] > max) {
					result[0] = nums[i];
					result[1] = nums[j];
				}
			}
		}
		return result;
	}
	
	// leetcode.sort Time ~O(NlogN)
	public static int[] MaxProduct2(int[] nums) {
		if (nums == null || nums.length < 2) return null;
		Arrays.sort(nums);
		int len = nums.length;
		return nums[0] * nums[1] > nums[len - 1] * nums[len -2] ?
				Arrays.copyOfRange(nums, 0, 2) : Arrays.copyOfRange(nums, len - 2, len);
	}
	
	// 4 points
	public static int[] MaxProduct3(int[] nums) {
		if (nums == null || nums.length < 2) return null;
		int fpos = Integer.MIN_VALUE, spos = Integer.MIN_VALUE;
		int fneg = Integer.MAX_VALUE, sneg = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > fpos) { // update fpos
				spos = fpos;
				fpos = nums[i];
			} else if (nums[i] > spos) { // update spos
				spos = nums[i];
			}
			if (nums[i] < fneg) {
				sneg = fneg;
				fneg = nums[i];
			} else if (nums[i] > fneg && nums[i] < sneg) {
				sneg = nums[i];
			}
		}
		return fpos * spos > fneg * sneg ? new int[]{fpos, spos}: new int[]{fneg, sneg};
	}
	

	public static void main(String[] args) {
		int[] test1 = new int[]{1, 4, 3, 6, 7, 0}; // {6, 7}
		int[] test2 = new int[]{-1, -3, -4, 2, 0, -5}; // {-4, -5}
		int[] test3 = new int[]{4, 2, 3, 7}; // 28
		int[] test4 = new int[]{2, 8, 9, 9}; // 72
		int[] test5 = new int[]{3, 5, 4}; // 15
		
		System.out.println(MaxProduct(test1));
		System.out.println(MaxProduct(test3));
		System.out.println(MaxProduct(test4));
		System.out.println(MaxProduct(test5));
//		System.out.println(Arrays.toString(MaxProduct3(test1)));
//		System.out.println(Arrays.toString(MaxProduct3(test2)));
	}

}
