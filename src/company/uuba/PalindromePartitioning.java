package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, 0, list, res);
        return res;
    }

    private void helper(String s, int pos, List<String> list, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String sub = s.substring(pos, i + 1);
            if (isPalindrome(sub)) {
                list.add(sub);
                helper(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    /**
     * Time: O(N * 2 ^ N), N is the length of string s
     * Space: O(N)
     */
}
