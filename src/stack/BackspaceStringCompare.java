package stack;

/**
 * 844. Backspace String Compare
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }

    private static String helper(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static boolean backspaceCompares(String S, String T) {
        int p = 0, q = 0;
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    p++; i--;
                } else if (p > 0) {
                    p--; i--;
                } else { // not # and p == 0
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    q++;
                    j--;
                } else if (q > 0) {
                    q--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false;
            i--; j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));

    }
}
