package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Contains Duplicate 2
 * contain duplicate numbers, positions less than k
 * @author yutian
 * @since Aug 3, 2015
 */
public class ContainsDuplicate2 {
	// HashMap Time O(N) Space O(N)
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
	        	if (map.containsKey(nums[i])) {
	        		if (i - map.get(nums[i]) <= k) {
	        			return true;
	        		}
	        	}
	        	map.put(nums[i], i);
        }
        return false;
    }
	
	// Set Time O(N), Space O(K)
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) set.remove(nums[i - k - 1]);
			if (!set.add(nums[i])) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 2));
		System.out.println(containsNearbyDuplicate(new int[] {1, 2, 1}, 2));
	}
	
}
