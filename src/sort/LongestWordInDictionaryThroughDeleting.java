package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 */
public class LongestWordInDictionaryThroughDeleting {

    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a,b) -> a.length() != b.length() ? b.length() - a.length() :  a.compareTo(b));
        for (String word : d) {
            if (compareWords(s, word)) {
                return word;
            }
        }
        return "";
    }

    public static boolean compareWords(String s1, String s2) {
        if (s2.length() > s1.length())
            return false;
        int i = 0, j = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; j++;
                if (j == s2.length()) return true;
            } else {
                i++;
            }
        }
        return j == s2.length();
    }

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"))));
        System.out.println(findLongestWord("bab", new ArrayList<>(Arrays.asList("ba", "ab", "a", "b")))); // ab
    }
}
