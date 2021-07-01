package company.uuba;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 679. 24 Game
 *
 * ou are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.
 *
 * You are restricted with the following rules:
 *
 * The division operator '/' represents real division, not integer division.
 * For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
 * For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
 * You cannot concatenate numbers together
 * For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
 * Return true if you can get such expression that evaluates to 24, and false otherwise.
 *
 * Example 1:
 *
 * Input: cards = [4,1,8,7]
 * Output: true
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 *
 * Input: cards = [1,2,1,2]
 * Output: false
 */
public class TwentyFourGame {
    boolean res = false;
    final double diff = 0.001;

    public boolean judgePoint24(int[] cards) {
        if (cards == null || cards.length == 0) {
            return res;
        }
        List<Double> list = new LinkedList<>();
        for (int i : cards) {
            list.add((double) i);
        }
        dfs(list);
        return res;
    }

    private void dfs(List<Double> list) {
        if (res) return;
        if (list.size() == 1 && Math.abs(list.get(0) - 24) < diff) {
            res = true;
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new LinkedList<>();
                double p = list.get(j), q = list.get(i);
                next.addAll(Arrays.asList(p + q, p - q, q - p, p * q));
                if (p > diff) next.add(q / p);
                if (q > diff) next.add(p / q);
                list.remove(i);
                list.remove(j);
                for (double n : next) {
                    list.add(n);
                    dfs(list);
                    list.remove(list.size() - 1);
                }
                list.add(j, p);
                list.add(i, q);
            }
        }
    }

    /**
     * Time: O(1)
     * Space: O(N)
     *
     * diff is for {3, 3, 8, 8}
     * -> 8/3=2.6666...
     * -> 3 - 8/3 = 0.333...
     * -> 8/0.333=23.999...
     * for base case in recursion, if we just compare the result with 24.0, then this case would be false.
     */
}
