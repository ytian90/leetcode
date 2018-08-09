package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum 3
 * @author yutian
 * @since Aug 14, 2015
 */
public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(k, n, 1, 0, list, res);
        return res;
    }

    private static void helper(int k, int n, int curr, int sum, List<Integer> list, List<List<Integer>> res) {
        if (sum > n) return;
        if (k == 0 && sum == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = curr; i <= 9; i++) {
            list.add(i);
            helper(k - 1, n, i + 1, sum + i, list, res);
            list.remove(list.size() - 1);
        }
    }

	List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSumm3(int k, int n) {
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

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
