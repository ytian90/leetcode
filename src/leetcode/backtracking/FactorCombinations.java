package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. Factor Combinations
 * @author yutian
 * @since Jan 6, 2016
 */
public class FactorCombinations {
	
	private static List<List<Integer>> res = new ArrayList<List<Integer>>();
	private static List<Integer> list = new ArrayList<>();
	
	public static List<List<Integer>> getFactors(int n) {
		helper(n, 2);
		return res;
	}

	private static void helper(int target, int start) {
		if (target == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= target; i++) {
            if (target % i == 0) {
                list.add(i);
                helper(target / i, i);
                list.remove(list.size() - 1);
            }
        }
	}

	public static void main(String[] args) {
		List<List<Integer>> r = getFactors(12);
		for (List<Integer> l: r) {
			System.out.println(l);
		}
	}

}
