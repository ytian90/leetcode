package string;

import java.util.*;

/**
 * 859. Buddy Strings
 */
public class BuddyStrings {
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray()) {
                if (set.contains(c)) return true;
                set.add(c);
            }
            return false;
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) diff.add(i);
        }
        return diff.size() == 2 && A.charAt(diff.get(0)) == B.charAt(diff.get(1))
                && A.charAt(diff.get(1)) == B.charAt(diff.get(0));
    }

    public boolean buddyStringss(String A, String B) {
        if (A.length() != B.length()) return false;
        List<Integer> diff = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            } else {
                map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
            }
        }
        if (diff.size() > 2 || diff.size() == 1) return false;
        else if (diff.size() == 2) {
            A = swap(A, diff.get(0), diff.get(1));
            return A.equals(B);
        } else {
            for (int n : map.values()) {
                if (n >= 2) return true;
            }
            return false;
        }
    }

    private String swap(String a, int i, int j) {
        char[] cs = a.toCharArray();
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("aa", ""));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
