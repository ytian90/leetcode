package leetcode.math;

/**
 * 660. Remove 9
 */
public class Remove9 {

    public static int newInteger(int n) {
        int res = 0;
        int base = 1;
        while (n > 0) {
            res += n % 9 * base;
            n /= 9;
            base *= 10;
        }
        return res;
    }

    public static int newIntegee(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

    public static void main(String[] args) {
        System.out.println(newInteger(9));
        System.out.println(newIntegee(10));
    }
}
