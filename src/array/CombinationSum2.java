package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * @author yutian
 * @since Aug 15, 2015
 */
public class CombinationSum2 {
	
	List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }
    void dfs(int[] candidates, int start, int target) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i - 1] == candidates[i]) continue;
            list.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	CombinationSum2 t = new CombinationSum2();
    	for (List<Integer> l : t.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)) {
    		System.out.println(l);
    	}
    }
}
