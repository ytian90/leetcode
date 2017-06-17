package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Contains Duplicate 3
 * @author yutian
 * @since Aug 13, 2015
 */
public class ContainsDuplicate3 {
	// BST + slide window: Time O(NlogK), Space O(K)
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			if (set.floor(c) != null && set.floor(c) >= c - t
					|| set.ceiling(c) != null && set.ceiling(c) <= c + t) {
				return true;
			} else {
				set.add(c);
				if (i >= k) set.remove(nums[i - k]);
			}
		}
		return false;
	}
	
	// Time O(N), Space O(N)
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long rNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = rNum / ((long) t + 1);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && rNum - map.get(bucket - 1) <= t) 
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - rNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, rNum);
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[]{2, 1}, 1, 1));
	}

}
