package leetcode.mj.oracle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=540261&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class UniqueCharacterInTwoStrings {

    public int countUniqueCharInString(String s1, String s2) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                set.add(e.getKey());
            }
        }
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
