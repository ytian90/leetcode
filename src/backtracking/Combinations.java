package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 77. Combinations
 * @author yutian
 * @since Aug 15, 2015
 */
public class Combinations {
	
	// 1. backtracking
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, k, 1, list, res);
        return res;
    }

    private void helper(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if (k == list.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    // 2. iterative
    public List<List<Integer>> combine2(int n, int k) {
    	if (n == 0 || k == 0 || k > n) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n + 1 - k; i++) res.add(Arrays.asList(i));
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                for (int m = list.get(list.size() - 1) + 1; m <= n - (k - i); m++) {
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(m);
                    tmp.add(newList);
                }
            }
            res = tmp;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Combinations t = new Combinations();
		for (List<Integer> l: t.combine(4, 2)) {
			System.out.println(l);
		}
	}
}
