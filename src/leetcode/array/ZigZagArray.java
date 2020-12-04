package leetcode.array;

import java.util.Arrays;

/**
 * ZigZag Array
 * GoDaddy
 * http://www.1point3acres.com/bbs/thread-143059-1-1.html
 * @author yutian
 * @since Jan 28, 2016
 */
public class ZigZagArray {
	
	public static void ZigZag(int[] nums) {
		if (nums == null || nums.length == 0) return;
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		while (i < j) {
			System.out.print(nums[j--] + " ");
			System.out.print(nums[i++] + " ");
			if (i == j) System.out.print(nums[i++]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ZigZag(new int[]{3, 6, 7, 9, -3});
		ZigZag(new int[]{3, 6, 9, -3});
	}

}
