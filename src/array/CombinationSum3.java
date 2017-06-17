package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum 3
 * @author yutian
 * @since Aug 14, 2015
 */
public class CombinationSum3 {
	List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1);
        return res;
    }
    
    void helper(int k, int n, int start) {
        if (k < 0 || n < 0) return;
        else if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
