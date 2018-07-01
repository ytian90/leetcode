package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 784. Letter Case Permutation
 */
public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), 0, res);
        return res;
    }

    private static void helper(char[] chars, int pos, List<String> res) {
        if (pos == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[pos])) {
            chars[pos] = Character.toLowerCase(chars[pos]);
            helper(chars, pos + 1, res);
            chars[pos] = Character.toUpperCase(chars[pos]);
        }
        helper(chars, pos + 1, res);
    }

    public static List<String> letterCasePermutations(String S) {
        if (S == null)
            return new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        q.add(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                char[] chars = q.poll().toCharArray();
                chars[i] = Character.toUpperCase(chars[i]);
                q.add(new String(chars));
                chars[i] = Character.toLowerCase(chars[i]);
                q.add(new String(chars));
            }
        }
        return new LinkedList<>(q);
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("C"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
    }
}
