package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 */
public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        compute(res, S.toCharArray(),0);
        return res;
    }

    public static void compute(List<String> ans, char[] chars, int index)
    {
        if (index == chars.length)
            ans.add(new String(chars));
        else
        {
            if(Character.isLetter(chars[index]))
            {
                chars[index] = Character.toUpperCase(chars[index]);
                compute(ans, chars,index + 1);
                chars[index] = Character.toLowerCase(chars[index]);
            }
            compute(ans, chars,index + 1);
        }
    }

    public static List<String> letterCasePermutation2(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        res.add("");
        for (char c : S.toCharArray()) {
            List<String> next = new ArrayList<>();
            if (Character.isLetter(c)) {

                for (String a : res) {
                    next.add(a + ("" + c).toLowerCase());
                    next.add(a + ("" + c).toUpperCase());
                }

            } else {
                for (String a : res) {
                    next.add(a + c);
                }
            }
            res = next;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("C"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
    }
}
