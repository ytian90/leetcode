package leetcode.array;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * @author yutian
 * @since Aug 22, 2015
 */
public class BestTimeToBuyAndSellStock4 {

	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2 || k == 0) {
			return 0;
		}
		int n = prices.length;
		if (k >= n / 2) return helper(prices);

		int[] buy = new int[k];
		int[] sell = new int[k];
		Arrays.fill(buy, Integer.MIN_VALUE);
		for (int p : prices) {
			for (int i = k - 1; i > 0; i--) {
				sell[i] = Math.max(sell[i], buy[i] + p);
				buy[i] = Math.max(buy[i], sell[i - 1] - p);
			}
			sell[0] = Math.max(sell[0], buy[0] + p);
			buy[0] = Math.max(buy[0], -p);
		}
		return sell[k - 1];
	}

	public int helper(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++) {
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		}
		return profit;
	}

	public int maxProfit0(int k, int[] prices) {
		int n = prices.length;
		if (k >= n / 2) return helper(prices);

		int[][] dp = new int[k + 1][n];
		for (int i = 1; i <= k; i++) {
			int tmpMax = -prices[0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
				tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
			}
		}
		return dp[k][n - 1];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock4 t = new BestTimeToBuyAndSellStock4();
		System.out.println(t.maxProfit(2, new int[]{2, 4, 1}));
		System.out.println(t.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
		System.out.println(t.maxProfit(1, new int[]{1, 2, 3}));
		System.out.println(t.maxProfit(1, new int[]{3, 3}));
		System.out.println(t.maxProfit(1, new int[]{3, 2, 1}));
		System.out.println(t.maxProfit(2, new int[]{1, 2, 1, 2, 3}));
	}

	/**
	 * dp[i, j] represents the max profit incr until prices[j] using at most i transactions.
	 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
	 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
	 * dp[0, j] = 0; 0 transactions makes 0 profit
	 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
	 */

	// Solution 1
	public int maxProfit1(int k, int[] prices) {
		int len = prices.length;
		int profit = 0;
		
		// as many transactions as we want.
		if (k >= len / 2) {
			for (int i = 0; i < len - 1; i++) {
				int diff = prices[i + 1] -  prices[i];
				if (diff > 0) profit += diff;
			}
			return profit;
		}
		
		// at most k transactions
		// d(i, j) = max{d(i, j - 1), max_{1 <= l <= j} {d(i - 1, l - 1) - p[l](buy) + p[j](sell)}}
		int[][] d = new int[k + 1][len];
		for (int i = 1; i <= k; i++) {
			int tempMax = d[i - 1][0] - prices[0];
			for (int j = 1; j < len; j++) {
				tempMax = Math.max(tempMax, d[i - 1][j - 1] - prices[j]);
				d[i][j] = Math.max(d[i][j - 1], prices[j] + tempMax);
			}
		}
		return d[k][len - 1];
	}
	
	// Solution 2
	public int maxProfit2(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int len = prices.length;
		int profit = 0;
		
		// as many transactions as we want.
		if (k >= len / 2) {
			for (int i = 0; i < len - 1; i++) {
				int diff = prices[i + 1] -  prices[i];
				if (diff > 0) profit += diff;
			}
			return profit;
		}
		
		int[] local = new int[k + 1];
		int[] global = new int[k + 1];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j-1] + (diff > 0 ? diff : 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}
	

}
