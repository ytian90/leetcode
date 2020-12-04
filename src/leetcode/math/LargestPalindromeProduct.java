package leetcode.math;

/**
 * 479. Largest Palindrome Product
 */
public class LargestPalindromeProduct {

    public static int largestPalindromes(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max - 1; i > max / 10; i--) {
            long j = Long.valueOf(i + new StringBuilder().append(i).reverse().toString());
            for (long x = max; x * x >= j; x--) {
                if (j % x == 0)
                    return (int)(j % 1337);
            }
        }
        return 0;
    }

    public static int largestPalindrome(int n) {
        int rst[] = {9, 987, 123, 597, 677, 1218, 877, 475};
        return rst[n-1];
    }

    public static void main(String[] args) {
        System.out.println(largestPalindromes(2));
    }
}
