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
	 * then we can easily maxPerformance SUM[i, j]. To achieve this,
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
		System.out.println(subarraySum(new int[]{-174,703,438,871,-241,781,429,-215,177,273,-628,106,235,-410,145,-793,-451,913,807,596,-982,709,585,-629,966,623,947,-467,-405,552,-858,8,-252,-128,-659,-233,-836,588,324,-817,175,-329,510,-388,878,398,231,730,66,-528,857,383,928,-924,199,-750,-868,-652,-133,408,391,685,483,-31,-986,945,271,778,-96,677,-961,-130,990,-891,-431,-317,-676,479,-919,-20,-814,3,-89,34,-292,548,201,-119,-94,-442,-934,-491,208,-722,115,527,73,636,-681,857}, -469));
	}

}
