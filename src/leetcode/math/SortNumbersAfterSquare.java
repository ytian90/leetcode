package leetcode.math;

import java.util.Arrays;

/**
 * MJ Google
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=299194&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * Give a integer list in ascending order, for every x in order,
 * do y = x ^2 + a * x, return the sorted order
 * example: [-2, -1, 0, 2] return [0, 1, 4, 4]
 * @author ytian
 *
 */
public class SortNumbersAfterSquare {
	
	public static int[] sort(int[] nums) {
		int[] res = new int[nums.length];
		int i = 0, j = nums.length - 1, k = j;
		while (i <= j) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				res[k] = nums[i] * nums[i];
				i++;
			} else {
				res[k] = nums[j] * nums[j];
				j--;
			}
			k--;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[]{-2, -1, 0, 2})));
	}

}
