package dynamicProgramming;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * @author yutian
 *
 */
public class PartitionEqualSubsetSum {
	
	public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
        	return true;
        int vo = Arrays.stream(nums).sum();
        if (vo % 2 != 0) return false;
        vo /= 2;
        boolean[] dp = new boolean[vo + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
        	for (int j = vo; j >= nums[i - 1]; j--) {
        		dp[j] = dp[j] || dp[j - nums[i - 1]];
        		if (dp[vo] == true) break;
        	}
        }
        return dp[vo];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{1, 5, 11, 5};
		System.out.println(canPartition(test));
	}

}
