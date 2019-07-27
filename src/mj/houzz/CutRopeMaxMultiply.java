package mj.houzz;

/**
 * https://www.1point3acres.com/bbs/thread-456875-1-1.html
 *
 *
 */
public class CutRopeMaxMultiply {

    // 第一个是dp题，给一根绳子，切成若干份，求(每段长度的乘积)的最大值
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

    // lintcode 1538
    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        int[] dp = new int[totalMoney + 1];
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            for (int j = totalMoney; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + damage[i]);
            }
        }
        return dp[totalMoney] >= totalDamage ? true : false;
    }

    // lintcode 800
    public double backpackIX(int n, int[] prices, double[] probability) {
        double[] dp = new double[n];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1.0;
        }
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }
        for (int i = 0; i < probability.length; i++) {
            for (int j = n; j >= prices[i]; j--) {
                dp[j] = Math.min(dp[j], dp[i - prices[i]] * probability[i]);
            }
        }
        return 1 - dp[n];
    }


    // lintcode: 700
    public int cutting(int[] prices, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + prices[i - 1]);
            }
        }
        return dp[n];
    }

    // lintcode: 749
    public String isBuild(int x) {
        int[] heights = {3, 7};
        boolean[] dp = new boolean[x + 1];
        dp[0] = true;
        for (int i = 0; i < 2; i++) {
            for (int j = heights[i]; j <= x; j++) {
                dp[j] = dp[j] || dp[j - heights[i]];
            }
        }
        return dp[x] ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(cutRope(5));
    }
}
