package company.lnkin;

/**
 * LC 744. Find Smallest Letter Greater Than Target
 *
 * Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
 *
 * Note that the letters wrap around.
 *
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 *
 * Example 1:
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Example 2:
 *
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Example 3:
 *
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 * Example 4:
 *
 * Input: letters = ["c","f","j"], target = "g"
 * Output: "j"
 * Example 5:
 *
 * Input: letters = ["c","f","j"], target = "j"
 * Output: "c"
 */
public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return ' ';
        }
        int n = letters.length, lo = 0, hi = n - 1;
        if (target >= letters[n - 1]) {
            target = letters[0];
        }
        else {
            target++;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] == target) {
                return target;
            } else if (letters[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return letters[lo];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // f
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')); // f
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g')); // j
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); // c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k')); // c
        System.out.println(nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n', }, 'e')); // n
    }
}
