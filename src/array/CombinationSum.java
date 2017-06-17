package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * @author yutian
 * @since Aug 15, 2015
 */
public class CombinationSum {
	private static List<List<Integer>> res = new ArrayList<List<Integer>>();
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		helper(candidates, target, 0);
		return res;
	}

	private static void helper(int[] c, int target, int start) {
		if (target < 0) return;
		else if (target == 0) {
			res.add(new ArrayList<Integer>(list));
		} else {
			for (int i = start; i < c.length; i++) {
				list.add(c[i]);
				helper(c, target - c[i], i);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{1}, 2));
	}
}
