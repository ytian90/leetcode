package leetcode.dynamicProgramming;

/**
 * Given a rod of length and prices at which different length of this rod can sell,
 * how do you cut this rod to maximize profit
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * https://www.youtube.com/watch?v=IRwVmTmN6go&index=12&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 */
public class CuttingRodToMaxProfit {

    public static int cutRod(int[] prices, int n) {
        if (n == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, prices[i] + cutRod(prices, n - i - 1));
        }
        return max;
    }

    public static int cutRod2(int[] prices, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{2, 5, 7, 8}, 4));
        System.out.println(cutRod2(new int[]{2, 5, 7, 8}, 4));
    }
}
