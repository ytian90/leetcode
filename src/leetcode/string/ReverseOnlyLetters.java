package leetcode.string;

/**
 * 917. Reverse Only Letters
 */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(chars[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(chars[j])) {
                j--;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("7_28]")); //  && i < j
    }
}
