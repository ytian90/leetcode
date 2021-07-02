package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 282. Expression Add Operators
 * Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1*2*3","1+2+3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2","2+3*2"]
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0*0","0+0","0-0"]
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        helper(num, target, res, "", 0, 0, 0);
        return res;
    }

    private void helper(String num, int target, List<String> res, String path, int pos, long value, long multiply) {
        if (pos == num.length()) {
            if (value == target) {
                res.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(num, target, res, path + curr, i + 1, curr, curr);
            } else {
                helper(num, target, res, path + "+" + curr, i + 1, value + curr, curr);
                helper(num, target, res, path + "-" + curr, i + 1, value - curr, -curr);
                helper(num, target, res, path + "*" + curr, i + 1, value - multiply + curr * multiply, curr * multiply);
            }
        }
    }
    /**
     * Time: O(N * 4 ^ N), N is the length of string num, 4 cases: +, -, * and next digit.
     * Space: O(N)
     */
}
