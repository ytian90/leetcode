package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 * @author ytian
 *
 */
public class LongestHarmoniousSubsequence {
	
	public static int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long n : nums) {
        	map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        for (long key : map.keySet()) {
        	if (map.containsKey(key + 1)) {
        		res = Math.max(res, map.get(key + 1) + map.get(key));
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
	}

}
