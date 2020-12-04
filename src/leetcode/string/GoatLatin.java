package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 824. Goat Latin
 */
public class GoatLatin {
    public static String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
        String res = "";
        String[] words = S.split("\\s");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            res += ' ' + (vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (int j = 0; j < i + 1; j++) {
                res += "a";
            }
        }
        return res.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
