package string;

/**
 * 796. Rotate String
 */
public class RotateString {

    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        return (A + A).contains(B);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
        System.out.println(rotateString("aa", "a"));
    }
}
