package leetcode.string;

/**
 * leetcode.cc189: page 71
 * Design an algorithm to print all permutations of a leetcode.string.
 * for simplicity, assume all characters are unique.
 */
public class PermutationsOfAString {
    public static void permute(String string, int l, int r) {
        if (l == r) {
            System.out.println(string);
        } else {
            for (int i = l; i <= r; i++) {
                string = swap(string, l, i);
                permute(string, l + 1, r);
                string = swap(string, l, i);
            }
        }
    }

    public static String swap(String s, int i, int j) {
        char t;
        char[] chars = s.toCharArray();
        t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        permute("ABCD", 0, 3);
    }
}
