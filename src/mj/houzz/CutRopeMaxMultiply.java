package mj.houzz;

/**
 * https://www.1point3acres.com/bbs/thread-456875-1-1.html
 *
 * 第一个是dp题，给一根绳子，切成若干份，求(每段长度的乘积)的最大值
 */
public class CutRopeMaxMultiply {

    public static int cutRope(int n) {
        if (n < 0) return 0;
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = i;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(5));
    }
}
