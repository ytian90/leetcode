package mj.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * lc890 word pattern match
 */
public class WordPattenMatch {
    // lc890
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private static boolean match(String word, String pattern) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (!map1.containsKey(c1)) {
                map1.put(c1, c2);
            }
            if (!map2.containsKey(c2)) {
                map2.put(c2, c1);
            }
            if (map1.get(c1) != c2 || map2.get(c2) != c1) {
                return false;
            }
        }
        return true;
    }

    private static boolean match2(String word, String pattern) {
        char[] ss = new char[256];
        char[] tt = new char[256];
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i), b = pattern.charAt(i);
            if (ss[a] == 0 && tt[b] == 0) {
                ss[a] = b;
                tt[b] = a;
            }
            if (ss[a] != b || tt[b] != a) return false;
        }
        return true;
    }
}
