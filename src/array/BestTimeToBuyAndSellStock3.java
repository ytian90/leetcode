package array;
/**
 * Best Time to Buy and Sell Stock III
 * @author yutian
 * @since Aug 22, 2015
 */
public class BestTimeToBuyAndSellStock3 {
	/**
	 * Let d(i) be the max profit when 1st transaction is in [0, i],
	 * and 2nd transaction is in[i, N - 1].
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		// f(i) = max profit in [0, i]
		// g(i) = max profit in [i + 1, n - 1]
		// max profit in [0, n - 1] = max{f(i) + g(i), for all 0 <= i <= n - 1}
		int N = prices.length;
		if (N < 2) return 0;
		int[] f = new int[N];
		int[] g = new int[N];
		
		// calculate f[i]
		int min = prices[0];
		for (int i = 1; i < N; i++) {
			min = Math.min(min, prices[i]);
			f[i] = Math.max(f[i - 1], prices[i] - min);
		}
		
		// calculate g[i]
		int max = prices[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			g[i] = Math.max(g[i + 1], max - prices[i]);
		}
		
		// calculate max profit
		int profit = 0;
		for (int i = 0; i < N; i++) {
			profit = Math.max(profit, f[i] + g[i]);
		}
		return profit;
	}
	
	/**
	 * Solution 2
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] local = new int[3];
		int[] global = new int[3];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = 2; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + (diff > 0? diff:0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[2];
	}
	
	/**
	 * Solution 3
	 * @param prices
	 * @return
	 */
	public int maxProfit3(int[] prices) {
		int len = prices.length;
		if (len < 2) return 0;
		int a, b, c, d;
		/*
		 * d is the value in the case when you have made a transaction before you have a share 
		 * at hand, that's basically the max from i to len. 
		 * c is the value in the case when you can make one transaction from days i to len. 
		 * So c is updated only if you buy a share on that day and sell afterward.
		 * b is the value in the case when you have a share at hand, and you can make one more
		 * transaction. So if you sell it on day i, it's prices[i] + c, otherwise it doesn't
		 * change.
		 * a is the value in the case when you can make two transactions.
		 */
		d = Math.max(prices[len-1], prices[len-2]);
		c = Math.max(prices[len-1] - prices[len-2], 0);
		b = d;
		a = c;
		for (int i = len - 3; i >= 0; i--) {
			a = Math.max(a, b - prices[i]);
            b = Math.max(b, c + prices[i]);
            c = Math.max(c, d - prices[i]);
            d = Math.max(d, prices[i]);
		}
		return a;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock3 t = new BestTimeToBuyAndSellStock3();
		System.out.println(t.maxProfit(new int[]{1, 2, 3}));
		System.out.println(t.maxProfit(new int[]{3, 3}));
		System.out.println(t.maxProfit(new int[]{3, 2, 1}));
		System.out.println(t.maxProfit(new int[]{1, 2, 1, 2, 3}));
	}
}
