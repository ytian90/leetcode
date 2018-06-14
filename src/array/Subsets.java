package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 78. Subsets
 * @author yutian
 * @since Aug 19, 2015
 */
public class Subsets {
	
	private static List<List<Integer>> res = new ArrayList<List<Integer>>();
	private static List<Integer> list = new ArrayList<>();

	// Solution 1 Time complexity is O(2^n)  Space complexity is O(n).
	public List<List<Integer>> subsets(int[] nums) {	
		Arrays.sort(nums); // require subset must be in non-descending order
		helper(nums, 0);
		return res;
	}

	private void helper(int[] nums, int start) {
//		if (!listSet.contains(list))
		res.add(new ArrayList<Integer>(list));
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			helper(nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	// Solution 4 with iteration
	public List<List<Integer>> subsets4(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				List<Integer> subset = new ArrayList<>(result.get(j));
				subset.add(nums[i]);
				result.add(subset);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Subsets t = new Subsets();
		for (List<Integer> l: t.subsets4(new int[]{1, 2, 3})) {
			System.out.println(l);
		}
//		System.out.println();
//		for (List<Integer> l: t.subsets(new int[]{1, 2, 3})) {
//			System.out.println(l);
//		}
	}
	
	// Solution 2
	public List<List<Integer>> subsets2(int[] nums) {
		int n = nums.length;
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		for (int i = 0; i < Math.pow(2, n); i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (((1 << j) & i) != 0) {
					subset.add(nums[j]);
				}
			}
			Collections.sort(subset);
			subsets.add(subset);
		}
		return subsets;
	}
	
	// Solution 3
	public List<List<Integer>> subsets3(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = nums.length;
		for (int i = 0; i < Math.pow(2, n); i++) {
			List<Integer> set = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (((i >> j) & 1) != 0) {
					set.add(nums[j]);
				}
			}
			result.add(set);
		}
		return result;
	}
}
