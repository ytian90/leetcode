package leetcode.math;

/**
 * 869. Reordered Power of 2
 */
public class ReorderedPowerOf2 {

    public static boolean reorderedPowerOf2(int N) {
        long c = helper(N);
        for (int i = 0; i < 32; i++) {
            if (helper(1 << i) == c) return true;
        }
        return false;
    }

    private static long helper(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int) Math.pow(10, N % 10);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));
    }
}
