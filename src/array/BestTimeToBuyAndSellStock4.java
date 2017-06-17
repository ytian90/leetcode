package array;
/**
 * Best Time to Buy and Sell Stock IV
 * @author yutian
 * @since Aug 22, 2015
 */
public class BestTimeToBuyAndSellStock4 {
	/**
	 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
	 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
	 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
	 * dp[0, j] = 0; 0 transactions makes 0 profit
	 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
	 */

	// Solution 1
	public int maxProfit(int k, int[] prices) {
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
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock4 t = new BestTimeToBuyAndSellStock4();
		System.out.println(t.maxProfit(1, new int[]{1, 2, 3}));
		System.out.println(t.maxProfit(1, new int[]{3, 3}));
		System.out.println(t.maxProfit(1, new int[]{3, 2, 1}));
		System.out.println(t.maxProfit(2, new int[]{1, 2, 1, 2, 3}));
	}
}
