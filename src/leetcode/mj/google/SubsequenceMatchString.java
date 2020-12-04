package leetcode.mj.google;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=568132&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D9%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 * 键盘一指滑动打字功能，比如说输入caront，然后你有个dictionary，然后你能找到car,cat
 */
public class SubsequenceMatchString {

    public static List<String> subsequenceMathString(String s, Set<String> dict) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : dict) {
            char c = word.charAt(0);
            if (map.containsKey(c)) {
                continue;
            }
            int pos = s.indexOf(c);
            if (pos != -1) {
                map.put(c, s.indexOf(c));
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : dict) {
            if (!map.containsKey(word.charAt(0))) {
                continue;
            }
            if (match(s.substring(map.get(word.charAt(0))), word)) {
                res.add(word);
            }
        }
        return res;
    }

    public static boolean match(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == t.length();
    }

    public static void main(String[] args) {
//        System.out.println(match("caront", "car"));
//        System.out.println(match("caront", "cat"));
//        System.out.println(match("caront", "catt"));
//        System.out.println(match("caront", "cap"));
        System.out.println(subsequenceMathString("caront", new HashSet<>(Arrays.asList("car", "cat", "catt", "cap", "error"))));
    }
}
