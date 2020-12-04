package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * @author yutian
 * @since Aug 15, 2015
 */
public class CombinationSum2 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, res);
        return res;
    }
    public static void helper(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i - 1] == candidates[i]) continue;
            list.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
