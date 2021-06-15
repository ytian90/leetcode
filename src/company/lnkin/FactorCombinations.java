package company.lnkin;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 254. Factor Combinations
 *
 * Numbers can be regarded as the product of their factors.
 *
 * For example, 8 = 2 x 2 x 2 = 2 x 4.
 * Given an integer n, return all possible combinations of its factors. You may return the answer in any order.
 *
 * Note that the factors should be in the range [2, n - 1].
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: []
 * Example 2:
 *
 * Input: n = 12
 * Output: [[2,6],[3,4],[2,2,3]]
 * Example 3:
 *
 * Input: n = 37
 * Output: []
 * Example 4:
 *
 * Input: n = 32
 * Output: [[2,16],[4,8],[2,2,8],[2,4,4],[2,2,2,4],[2,2,2,2,2]]
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, 2, list, res);
        return res;
    }

    private void helper(int n, int start, List<Integer> list, List<List<Integer>> res) {
        if (n == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(n / i, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    /**
     * Time: O(NlogN)
     * Space: O(logN)
     */
}
