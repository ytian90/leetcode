package dynamicProgramming;
/**
 * 53. Maximum Subarray (Maximum Sum Subarray)
 * name has been changed to Maximum Subarray
 * @author yutian
 * @since Aug 1, 2015
 */
public class MaximumSubarray {
	// Solution 1: Divide and Conquer
	public static int maxSubArray(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private static int helper(int[] nums, int lo, int hi) {
		if (lo > hi) return Integer.MIN_VALUE;
		int mid = (lo + hi) / 2;
		int leftAns = helper(nums, lo, mid - 1);
		int rightAns = helper(nums, mid + 1, hi);
		int lMaxSum = 0, sum = 0;
		for (int i = mid - 1; i >= lo; i--) {
			sum += nums[i];
			lMaxSum = Math.max(sum, lMaxSum);
		}
		int rMaxSum = 0;
		sum = 0;
		for (int i = mid + 1; i <= hi; i++) {
			sum += nums[i];
			rMaxSum = Math.max(sum, rMaxSum);
		}
		return Math.max(lMaxSum + nums[mid] + rMaxSum, Math.max(leftAns, rightAns));
	}
	
	// Solution 2: Dynamic programming Time ~O(N), Space ~O(1)
	public static int maxSubArray2(int[] nums) {
		int maxEndingHere = nums[0], maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	// Solution 2: Dynamic programming Time ~O(N), Space ~O(N)
	public static int maxSubArray3(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] test1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray2(test1));
	}
	
}
