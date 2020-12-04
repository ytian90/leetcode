package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 758. Bold Words in String
 */
public class BoldWordsInString {

    public static String boldWords(String[] words, String S) {
        int[] s = new int[S.length() + 1];
        for (String w : words) {
            int i = 0;
            while ((i = S.indexOf(w, i)) >= 0) {
                s[i]++;
                s[i + w.length()]--;
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int prev = 0, sum = 0;
        for (int i = 0; i <= S.length(); i++) {
            sum += s[i];
            if (sum > 0 && prev == 0) sb.append("<b>");
            if (sum == 0 && prev > 0) sb.append("</b>");
            if (i < S.length()) sb.append(S.charAt(i));
            prev = sum;
        }
        return sb.toString();
    }

    public static String boldWordss(String[] words, String S) {
        Set<Integer> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < S.length() - word.length() + 1; i++) {
                if (S.substring(i, i + word.length()).equals(word)) {
                    for (int j = i; j < i + word.length(); j++) {
                        set.add(j);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(i) && !set.contains(i - 1)) sb.append("<b>");
            sb.append(S.charAt(i));
            if (set.contains(i) && !set.contains(i + 1)) sb.append("</b>");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(boldWords(new String[]{"ab", "bc"}, "aabcd"));
    }
}
