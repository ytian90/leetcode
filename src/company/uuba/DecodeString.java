package company.uuba;

import java.util.Stack;

/**
 * LC 394. Decode String
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> freq = new Stack<>();
        Stack<String> strs = new Stack<>();
        String w = "";
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                freq.push(Integer.valueOf(s.substring(start, i)));
            } else if (c == '[') {
                strs.push(w);
                w = "";
                i++;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(strs.pop());
                int size = freq.pop();
                for (int j = 0; j < size; j++) {
                    sb.append(w);
                }
                w = sb.toString();
                i++;
            } else {
                w += c;
                i++;
            }
        }
        return w;
    }
    /**
     * Time: O(maxK * N), maxK is the maximum value of k and n is the length of a given string s.
     * Example, for s = 20[a10[bc]], maxK is 20.
     * Space: O(N + M), N is the number of digits(0-9), M is the number of letters(a-z).
     */
}
