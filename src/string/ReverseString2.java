package string;

/**
 * 541. Reverse String II
 */
public class ReverseString2 {

    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        if (k > s.length()) {
            reverse(c, 0, c.length - 1);
            return new String(c);
        }
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(c, i, Math.min(i + k - 1, s.length() - 1));
        }
        return new String(c);
    }

    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++; j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcdefg", 8));
        System.out.println(reverseStr("abcdefg", 3));
        System.out.println(reverseStr("abcdefgh", 2));
        System.out.println(reverseStr("abcdefghi", 2));
        System.out.println(reverseStr("abcdefghij", 2));
        System.out.println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }
}
