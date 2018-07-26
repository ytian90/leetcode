package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 676. Implement Magic Dictionary
 */
public class ImplementMagicDictionary {

    Map<String, List<int[]>> map;

    /** Initialize your data structure here. */
    public ImplementMagicDictionary() {
        this.map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[]{i, s.charAt(i)};
                List<int[]> val = map.getOrDefault(key, new ArrayList<>());
                val.add(pair);
                map.put(key, val);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementMagicDictionary obj = new ImplementMagicDictionary();
        obj.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(obj.search("hello"));
        System.out.println(obj.search("hhllo"));
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("leetcoded"));

    }
}
