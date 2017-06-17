package bitManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Single Number
 * @author yutian
 * @since Jul 28, 2015
 */
public class SingleNumber {
	// Solution 1: Hash
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : nums) {
			int count = map.containsKey(x) ? map.get(x) : 0;
			map.put(x, count + 1);
		}
		for (int x : nums) {
			if (map.get(x) == 1) {
				return x;
			}
		}
		throw new IllegalArgumentException("No single element");
	}
	// Solution 2: Set
	public int singleNumber2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int x : nums) {
			if (set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		return set.iterator().next();
	}
	// Solution 3: XOR
	public int singleNumber3(int[] nums) {
		int res = 0;
		for (int x: nums) {
			res ^= x;
		}
		return res;
	}
}
