package string;

/**
 * Given two string s and t and a positive integer k determine
 * whether we can swap any two characters in string s at most
 * K times so that s is equal to t
 */
public class Match2StringsWithKSwaps {

    public static boolean canBeChanged(String s, String t, int k) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int j = 0;
        char[] a = s.toCharArray(), b = t.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) continue;
            j = i;
            while (j < a.length && a[j] != b[i]) j++;
            if (j == a.length) return false;
            else {
                swap(a, i, j);
                k--;
            }
        }
        return k >= 0;
    }

    private static void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(canBeChanged("cdab", "abcd", 2));
        System.out.println(canBeChanged("cdab", "abcd", 1));
        System.out.println(canBeChanged("dbca", "abcd", 1));
        System.out.println(canBeChanged("dbca", "abcd", 0));
    }
}
