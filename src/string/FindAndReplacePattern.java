package string;

import java.util.*;

/**
 * 890. Find and Replace Pattern
 */
public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        boolean valid = true;
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < word.length() && valid; i++) {
                Character c = word.charAt(i);
                Character d = pattern.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c) != d) valid = false;
                } else if (map.containsValue(d))
                    valid = false;
                map.put(c, d);
            }
            if (valid) res.add(word);
            valid = true;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }

    public static List<String> findAndReplacePattarn(String[] words, String pattern) {
        int[] p = helper(pattern);
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (Arrays.equals(helper(w), p)) res.add(w);
        }
        return res;
    }

    private static int[] helper(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(s.charAt(i), map.size());
            res[i] = map.get(s.charAt(i));
        }
        return res;
    }

}
