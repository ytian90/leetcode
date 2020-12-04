package leetcode.hashtable;

import java.util.HashMap;

/**
 * 325. Maximum Size Subarray Sum Equals K
 * @author yutian
 * @since Jan 17, 2016
 */
public class MaximumSizeSubarraySumEqualsK {
	/*
	 * The HashMap stores the sum of all elements before index i as key, 
	 * and i as value. For each i, check not only the current sum but 
	 * also (currentSum - previousSum) to see if there is any that equals 
	 * k, and update max length.
	 */
	public static int maxSubArrayLen(int[] nums, int k) {
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i + 1;
            if (map.containsKey(sum - k)) 
            	max = Math.max(max, i - map.get(sum - k));
            else if (!map.containsKey(sum)) // be careful
            	map.put(sum, i); 
        }
        return max;
    }

	public static void main(String[] args) {
		int[] t1 = new int[]{1, -1, 5, -2, 3};
		int[] t2 = new int[]{-2, -1, 2, 1};
		int[] t3 = new int[]{1, 0, -1};
		int[] t4 = new int[]{-10, 0, -1};
		System.out.println(maxSubArrayLen(t1, 5));
		System.out.println(maxSubArrayLen(t1, 6));
		System.out.println(maxSubArrayLen(t2, 3));
		System.out.println(maxSubArrayLen(t2, 1));
		System.out.println(maxSubArrayLen(t3, -1));
		System.out.println(maxSubArrayLen(t4, 1));
		
	}

}
