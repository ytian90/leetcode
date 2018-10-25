package string;

/**
 * 925. Long Pressed Name
 */
public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) return false;
        int n = name.length(), m = typed.length();
        if (n > m) return false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            char a = name.charAt(i);
            char b = typed.charAt(j);
            if (a == b) {
                i++; j++;
            } else {
                if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return i == n? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));

    }

}
