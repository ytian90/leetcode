package leetcode.uber;

import java.util.Arrays;

/**
 * 判断两个字符串是否相似 相似的定义是可以
 * 1. 任意swap character
 * 2. 任意把一种character的所有appearance和另外一个character的appearance呼唤
 */
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int map1[] = new int[26];
        int map2[] = new int[26];
        for (char c : word1.toCharArray()) {
            map1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            map2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map1[i] == 0 && map2[i] > 0 || map1[i] > 0 && map2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(map1);
        Arrays.sort(map2);
        return Arrays.equals(map1, map2);

    }

}
