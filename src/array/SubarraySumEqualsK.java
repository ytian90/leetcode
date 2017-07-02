package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * @author ytian
 *
 */
public class SubarraySumEqualsK {
	
	/*
	 * we know the key to solve this problem is SUM[i, j]. 
	 * So if we know SUM[0, i - 1] and SUM[0, j], 
	 * then we can easily get SUM[i, j]. To achieve this, 
	 * we just need to go through the array, calculate 
	 * the current sum and save number of all seen PreSum 
	 * to a HashMap. Time complexity O(n), Space complexity O(n).
	 */
	
	public static int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (map.containsKey(sum - k)) {
        		res += map.get(sum - k);
        	}
        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
	}

}
