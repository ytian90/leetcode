package leetcode.dynamicProgramming;
/**
 * Given an leetcode.array with integers, find two indices i and j  (j>=i),
 * such that the value of A[i]+A[j]+ (j - i) is maximized. 
 * Return (i, j).
 * http://stackoverflow.com/questions/25604175/find-which-two-values-in-an-array-maximize-a-given-expression
 * @author yutian
 * @since Jan 8, 2016
 */
public class MaxExpression {
	// Solution 1
	public static int max(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		int result = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i] - i);
			result = Math.max(result, nums[i] + i + max);
		}
		return result;
	}
	
	// Solution 2
	public static int max2(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		int max = Integer.MIN_VALUE, curr;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				curr = nums[j] + nums[i] + (j - i);
				if (curr > max) max = curr;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] test = new int[]{2, 1, 3, -1, 3, 2, -3, 2};
		System.out.println(max(test));
		System.out.println(max2(test));
	}

}
