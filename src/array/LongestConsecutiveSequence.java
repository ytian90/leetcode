package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * @author yutian
 * @since Aug 23, 2015
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int i : nums) set.add(i);
		for (int i : nums) {
			int len = 1;
			for (int j = i + 1; set.contains(j); j++) {
				len++;
				set.remove(j);
			}
			for (int j = i - 1; set.contains(j); j--) {
				len++;
				set.remove(j);
			}
			set.remove(i);
			res = Math.max(res, len);
		}
		return res;
	}
	
	public int longestConsecutive2(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (!map.containsKey(n)) {
				int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
				int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
				int sum = left + right + 1;
				map.put(n, sum);
				res = Math.max(res, sum);
				map.put(n - left, sum);
				map.put(n + right, sum);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LongestConsecutiveSequence sol = new LongestConsecutiveSequence();
		int[] t = new int[]{1, 2, 1};
		System.out.println(sol.longestConsecutive2(t));
	}
}
