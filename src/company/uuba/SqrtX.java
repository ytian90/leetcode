package company.uuba;

/**
 * LC 69. Sqrt(x)
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                lo = mid + 1;
            }
        }
        return lo;
    }
    /**
     * Time: O(logN)
     * Space: O(1)
     */
}
