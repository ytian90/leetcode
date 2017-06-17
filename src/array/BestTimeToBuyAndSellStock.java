package array;
/**
 * Best Time to Buy and Sell Stock
 * @author yutian
 * @since Aug 22, 2015
 * 
 * Say you have an array for which the ith element is the price 
 * of a given stock on day i. If you were only permitted to 
 * complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the 
 * maximum profit.
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) 
			return 0;
		// d(i) = max{d(i - 1), current profit}
		int N = prices.length;
		if (N < 2) return 0;
		int profit = 0, min = prices[0];
		for (int i = 1; i < N; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock t = new BestTimeToBuyAndSellStock();
		System.out.println(t.maxProfit(new int[]{1, 2, 3}));
		System.out.println(t.maxProfit(new int[]{3, 3}));
		System.out.println(t.maxProfit(new int[]{3, 2, 1}));
		System.out.println(t.maxProfit(new int[]{1, 2, 1, 2, 3}));
	}
}
