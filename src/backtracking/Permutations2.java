package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 * 
 * @author yutian
 * @since Aug 18, 2015
 */
public class Permutations2 {
	// recursion backtracking time O(N!)
	public static List<List<Integer>> permuteUnique_recur(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		helper(nums, new ArrayList<Integer>(), new HashSet<>(), res);
		return res;
	}

	private static void helper(int[] nums, List<Integer> list, Set<Integer> visited, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// skip the duplicated elements
			if (visited.contains(i) || i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i])
				continue;
			list.add(nums[i]);
			visited.add(i);
			helper(nums, list, visited, res);
			list.remove(list.size() - 1);
			visited.remove(i);
		}
	}

	// iterative
	public List<List<Integer>> permuteUnique_itera(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> next = new HashSet<>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    next.add(new ArrayList<>(l));
                    l.remove(j);
                }
            }
            res = next;
        }
        return new ArrayList<List<Integer>>(res);
	}

	public static void main(String[] args) {
		List<List<Integer>> r = permuteUnique_recur(new int[] { 1, 1, 2 });
		// List<List<Integer>> r2 = permuteUnique(new int[]{1, 1});
		for (List<Integer> i : r) {
			System.out.println(i);
		}
	}

}
