package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * @author ytian
 *
 */
public class ContinuousSubarraySum {
	
	public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sumSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
        	sumSoFar += nums[i];
        	if (k != 0) sumSoFar %= k;
        	Integer prev = map.get(sumSoFar);
        	if (prev != null) {
        		if (i - prev > 1) return true;
        	}
        	else map.put(sumSoFar, i);
        }
        return false;
    }

	public static void main(String[] args) {
		int[] test1 = new int[]{23, 2, 4, 6, 7};
		System.out.println(checkSubarraySum(test1, 6));
		
		int[] test2 = new int[]{23, 2, 6, 4, 7};
		System.out.println(checkSubarraySum(test2, 6));
	}

}
