package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 820. Short Encoding of Words
 */
public class ShortEncodingOfWords {

    public static int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            for (int i = 1; i < w.length(); i++) {
                s.remove(w.substring(i));
            }
        }
        int res = 0;
        for (String w : s) {
            res += w.length() + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
