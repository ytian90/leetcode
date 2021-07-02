package company.uuba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC 301. Remove Invalid Parentheses
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int lrm = 0, rrm = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lrm++;
            } else if (c == ')') {
                if (lrm > 0) {
                    lrm--;
                } else {
                    rrm++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        helper(s, res, "", 0, lrm, rrm, 0);
        return new ArrayList<>(res);
    }

    private void helper(String s, Set<String> res, String path, int pos, int lrm, int rrm, int open) {
        if (lrm < 0 || rrm < 0 || open < 0) {
            return;
        }
        if (pos == s.length()) {
            if (lrm == 0 && rrm == 0 && open == 0) {
                res.add(path);
            }
            return;
        }
        char c = s.charAt(pos);
        if (c == '(') {
            helper(s, res, path + c, pos + 1, lrm, rrm, open + 1);
            helper(s, res, path, pos + 1, lrm - 1, rrm, open);
        } else if (c == ')') {
            helper(s, res, path + c, pos + 1, lrm, rrm, open - 1);
            helper(s, res, path, pos + 1, lrm, rrm - 1, open);
        } else {
            helper(s, res, path + s.charAt(pos), pos + 1, lrm, rrm, open);
        }
    }
    /**
     * Time: O(2 ^ N)
     * Space: O(N)
     */
}
