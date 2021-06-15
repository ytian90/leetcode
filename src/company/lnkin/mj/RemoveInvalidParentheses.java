package company.lnkin.mj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC 301. Remove Invalid Parentheses
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764994&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rmL++;
            } else if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        helper(s, 0, new StringBuilder(), res, rmL, rmR, 0);
        return new ArrayList<>(res);
    }

    private void helper(String s, int i, StringBuilder sb, Set<String> res, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int size = sb.length();
        if (c == '(') {
            helper(s, i + 1, sb, res, rmL - 1, rmR, open);
            helper(s, i + 1, sb.append(c), res, rmL, rmR, open + 1);
        } else if (c == ')') {
            helper(s, i + 1, sb, res, rmL, rmR - 1, open);
            helper(s, i + 1, sb.append(c), res, rmL, rmR, open - 1);
        } else {
            helper(s, i + 1, sb.append(c), res, rmL, rmR, open);
        }
        sb.setLength(size);
    }
}
