package leetcode.array;

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
        helper(k, n, 0, 1, list, res);
        return res;
    }

    public static void helper(int k, int n, int sum, int start, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k && sum == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            helper(k, n, sum + i, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 15));
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
