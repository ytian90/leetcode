package mj.houzz;

/**
 * Number format
 */
public class NumberFormat {

    public static boolean validate(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        if (s.indexOf('.') != s.lastIndexOf('.')) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("12.3459"));
        System.out.println(validate(" 12.3459 "));
        System.out.println(validate("1 2.3459"));
        System.out.println(validate("12.3 459"));
        System.out.println(validate("12.34x59"));
        System.out.println(validate("12.34.59"));
    }
}
