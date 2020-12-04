package leetcode.greedy;

/**
 * 738. Monotone Increasing Digits
 */
public class MonotoneIncreasingDigits {

    public static int monotoneIncreasingDigits(int N) {
        if (N <= 9) {
            return N;
        }
        char[] c = String.valueOf(N).toCharArray();
        int mark = c.length;
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] < c[i - 1]) {
                mark = i - 1;
                c[i - 1]--;
            }
        }
        for (int i = mark + 1; i < c.length; i++) {
            c[i] = '9';
        }
        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
    }
}
