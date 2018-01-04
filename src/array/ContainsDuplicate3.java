package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220. Contains Duplicate 3
 * @author yutian
 * @since Aug 13, 2015
 */
public class ContainsDuplicate3 {
	// BST + slide window: Time O(NlogK), Space O(K)
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 2 || k == 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<>();
		int i = 0;
		while (i < nums.length) {
			Long floor = set.floor((long) nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);
			if ((floor != null && nums[i] - floor <= t) || (ceiling != null && ceiling - nums[i] <= t)) {
				return true;
			}
			set.add((long) nums[i++]);
			if (i > k) {
				set.remove((long) nums[i - k - 1]);
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
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1}, 1, 1));
		System.out.println(containsNearbyAlmostDuplicate(new int[]{2, 1}, 1, 1));
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1)); // line 24
		System.out.println(containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3, 3));
	}

}
