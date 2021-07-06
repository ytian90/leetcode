package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombinationsOfAPhoneNumber {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(digits, res, 0, "");
        return res;
    }

    private void helper(String digits, List<String> res, int pos, String word) {
        if (pos == digits.length() && word.length() == digits.length()) {
            res.add(word);
            return;
        }
        for (int i = pos; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            for (char c : map[num].toCharArray()) {
                helper(digits, res, i + 1, word + c);
            }
        }
    }
    /**
     * Time: O(N * 4 ^ N), where N is the length of digits
     * Space: O(N)
     */
}
