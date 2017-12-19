package dynamicProgramming;
/**
 * 152. Maximum Product Subarray
 * @author yutian
 * @since Aug 1, 2015
 */
public class MaximumProductSubarray {
	// 1-d DP: Time ~O(N), Space ~O(1)
	public static int maxProduct(int[] nums) {
		if (nums.length == 0) return 0;
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
            min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
            res = Math.max(max, res);
        }
        return res;
	}
	
	public static int maxProduct2(int[] nums) {
		int res = nums[0], max = nums[0], min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				max = Math.max(max * nums[i], nums[i]);
				min = Math.min(min * nums[i], nums[i]);
			} else {
				int lastMax = max;
				max = Math.max(min * nums[i], nums[i]);
				min = Math.min(lastMax * nums[i], nums[i]);
			}
			res = Math.max(res, max);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{2,3,-2,4};
		System.out.println(maxProduct(test));
	}
}
