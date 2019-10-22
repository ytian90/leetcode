package array;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * @author yutian
 * @since Aug 23, 2015
 */
public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 1, currMax = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] == nums[i - 1] + 1) {
				currMax++;
			} else {
				max = Math.max(max, currMax);
				currMax = 1;
			}
		}
		return Math.max(max, currMax);
	}

	public static int longestConsecutive2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n)) {
				continue;
			}
			int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
			int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
			int sum = left + right + 1;
			res = Math.max(res, sum);
			map.put(n, sum);
			map.put(n - left, sum);
			map.put(n + right, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive(new int[]{1, 2, 1}));
	}

	public static int longestConsecutive1(int[] nums) {
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
}
