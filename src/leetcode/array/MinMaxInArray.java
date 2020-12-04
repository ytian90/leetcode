package leetcode.array;
/**
 * Return the max and min back from a leetcode.array
 * @author yutian
 * @since Dec 16, 2015
 */
public class MinMaxInArray {
	
	// Solution 1 Time O(2n)
	public static int[] minMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		return new int[]{max, min};
	}
	
	// Solution 2 Time O(3n/2)
	public static int[] minMax2(int[] nums) {
		int max = nums[0], min = nums[0];
		for (int i = 1; i < nums.length; i += 2) { // compare 3 times, 
			if (nums[i - 1] < nums[i]) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i - 1]);
			} else {
				max = Math.max(max, nums[i - 1]);
				min = Math.min(min, nums[i]);
			}
		}
		if (nums.length % 2 != 0) {
			max = Math.max(max, nums[nums.length - 1]);
			min = Math.min(min, nums[nums.length - 1]);
		}
		return new int[]{max, min};
	}

	public static void main(String[] args) {
		
	}

}
