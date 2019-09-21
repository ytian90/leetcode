package mj.airbnb;

import java.util.*;

/**
 * 8. Palindrome Pairs
 */
public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            int n = reverse.length();
            for (int cut = 0; cut <= n; cut++) {
                String left = reverse.substring(0, cut);
                String right = reverse.substring(cut);
                if (map.containsKey(left) && map.get(left) != i && isPalindrome(right)) {
                    res.add(Arrays.asList(map.get(left), i));
                }
                if (cut != 0 && map.containsKey(right) && map.get(right) != i && isPalindrome(left)) {
                    res.add(Arrays.asList(i, map.get(right)));
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{}));
        System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
        System.out.println(palindromePairs(new String[]{"bat","tab","cat"}));
    }
}
