package leetcode.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * input: abababababac , {ab, abab, abc}问对应的String在大字符里出现了几次，不考虑重叠情况，  output {4, 2, 0}
 */
public class CountSubstringOccurances {

    public static List<Integer> count(String text, List<String> list) {
        List<Integer> res = new ArrayList<>();
        if (text == null || text.length() == 0 || list == null || list.size() == 0) {
            return res;
        }
        for (String s : list) {
            res.add(helper(text, s));
        }
        return res;
    }

    private static int helper(String text, String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return text.split(s, -1).length - 1;
    }

    public static void main(String[] args) {
        System.out.println(count("ababababac", Arrays.asList("ab", "abab", "abc")));
    }

}
