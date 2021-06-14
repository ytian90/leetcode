package company.lnkin;

/**
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long lo = 2, hi = num / 2;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long x = mid * mid;
            if (x == num) {
                return true;
            }
            if (x > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

}
