package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. Longest Word in Dictionary
 */
public class LongestWordInDictionary {

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() -1))) {
                res = w.length() > res.length() ? w : res;
                set.add(w);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{
                "w","wo","wor","worl", "world"
        }));
        System.out.println(longestWord(new String[]{
                "a", "banana", "app", "appl", "ap", "apply", "apple"
        }));
    }
}
