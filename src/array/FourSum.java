package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4 Sum
 * @author yutian
 * @since Aug 18, 2015
 */
public class FourSum {
	// Two pointers: Time ~ O(N^3), Space ~ O(1) 
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
		if (nums.length < 4) return listSet;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i = increment(nums, i)) {
			for (int j = i + 1; j < nums.length - 2; j = increment(nums, j)) {
				int a = nums[i], b = nums[j], lo = j + 1, hi = nums.length - 1;
				while (lo < hi) {
					int c = nums[lo], d = nums[hi];
					int sum = a + b + c + d;
					if (sum == target) {
						List<Integer> list = Arrays.asList(a, b, c, d);
						listSet.add(list);
						lo = increment(nums, lo);
						hi = decrement(nums, hi);
					} else if (sum < target) {
						lo = increment(nums, lo);
					} else {
						hi = decrement(nums, hi);
					}
				}
			}
		}
		return listSet;
	}

	private int increment(int[] nums, int low) {
		while (low < nums.length - 1 && nums[low] == nums[++low]) {}
		return low;
	}
	
	private int decrement(int[] nums, int high) {
		while (high > 0 && nums[high] == nums[--high]) {}
		return high;
	}
}
