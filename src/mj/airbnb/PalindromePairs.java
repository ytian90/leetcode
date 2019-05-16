package mj.airbnb;

import java.util.*;

/**
 * 8. Palindrome Pairs
 */
public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 0)
            return res;
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String rev_s2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(rev_s2) && map.get(rev_s2) != i) {
                        res.add(new ArrayList<>(Arrays.asList(i, map.get(rev_s2))));
                    }
                }
                if (isPalindrome(s2) && s2.length() != 0) {
                    String rev_s1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(rev_s1) && map.get(rev_s1) != i) {
                        res.add(new ArrayList<>(Arrays.asList(i, map.get(rev_s1))));
                    }
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{
                "abcd","dcba","lls","s","sssll"
        }));
        System.out.println(palindromePairs(new String[]{
                "bat","tab","cat"
        }));
    }
}
