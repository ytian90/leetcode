package mj.houzz;

/**
 * Simple version of leetcode 65
 * Revmoe exponent 'e' requirement
 * https://www.1point3acres.com/bbs/thread-317047-1-1.html
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && isSign(s.charAt(i))) {
            i++;
        }
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        return isNumeric && i == n;
    }

    private static boolean isSign(char c ) {
        return c == '+' || c == '-';
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0"));
        System.out.println(isNumber("0 "));
        System.out.println(isNumber(" 0.1 "));
        System.out.println(isNumber(" .1 "));
        System.out.println(isNumber("0ab"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("++5"));
        System.out.println(isNumber("3 -"));
        System.out.println(isNumber("22."));
        System.out.println(isNumber("22.3"));

    }
}
