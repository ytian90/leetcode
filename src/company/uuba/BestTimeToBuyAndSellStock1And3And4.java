package company.uuba;

import java.util.Arrays;

/**
 * LC 123. Best Time to Buy and Sell Stock III
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Example 4:
 *
 * Input: prices = [1]
 * Output: 0
 */
public class BestTimeToBuyAndSellStock1And3And4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][n - 1];
    }
    /**
     * Time: O(K * N)
     * Space: O(K * N)
     */

    public int maxProfit_v2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[3];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k - 1]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[2];
    }
    /**
     * Time: O(K * N)
     * Space: O(K + N)
     */

    public int maxProfit_v3(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = buy1;
        int sell1 = 0, sell2 = 0;
        for (int p : prices) {
            buy1 = Math.min(buy1, p);
            sell1 = Math.max(sell1, p - buy1);
            buy2 = Math.min(buy2, p - sell1);
            sell2 = Math.max(sell2, p - buy2);
        }
        return sell2;
    }
    /**
     * Time: O(N)
     * Space: O(1)
     */

    public int maxProfitQ1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i : prices) {
            res = Math.max(res, i - min);
            min = Math.min(min, i);
        }
        return res;
    }
    /**
     * Time: O(N)
     * Space: O(1)
     */
}
