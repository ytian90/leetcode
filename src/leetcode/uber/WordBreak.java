package leetcode.uber;

import java.util.Set;

/**
 * 前缀字符串：
 * 给一个字符串数组a，正确前缀的定义是字符串数组a里面的字符串按0123...的顺序拼接在一起，比如[a, b, c]那么合理的前缀有[a, ab, abc]，再给定一个b字符串数组，问b里面所有的字符串是否符合a构成的合理前缀。
 * 输入 a: [one, two, three] b: [onetwo, one]
 * 输出 True
 * 输出 a: [one, two, three] b: [onetwo, two]
 * 输出 False
 */
public class WordBreak {
    public static boolean isPossible(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dict.contains(sub) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
