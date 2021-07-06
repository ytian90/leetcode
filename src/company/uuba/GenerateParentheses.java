package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        helper(res, n, n, "");
        return res;
    }

    private void helper(List<String> res, int lrm, int rrm, String word) {
        if (lrm == 0 && rrm == 0) {
            res.add(word);
            return;
        }
        if (lrm < 0 || rrm < 0 || lrm > rrm) {
            return;
        }
        helper(res, lrm - 1, rrm, word + "(");
        helper(res, lrm, rrm - 1, word + ")");
    }
    /**
     * Time: O(2 ^ N)
     * Space: O(2 ^ N)
     */
}
