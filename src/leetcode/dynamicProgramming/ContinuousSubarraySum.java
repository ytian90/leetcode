package leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * @author ytian
 *
 */
public class ContinuousSubarraySum {
	
	public static boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return false;
		int n = nums.length, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (k != 0) sum %= k;
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1)
					return true;
			} else {
				map.put(sum, i);
			}
		}
		return false;
    }

	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
		System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
		System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 0));
		System.out.println(checkSubarraySum(new int[]{0, 0}, 0));
	}

}
