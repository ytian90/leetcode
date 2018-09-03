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
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int min = prices[0], res = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			res = Math.max(res, prices[i] - min);
		}
		return res;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock t = new BestTimeToBuyAndSellStock();
		System.out.println(t.maxProfit(new int[]{1, 2, 3}));
		System.out.println(t.maxProfit(new int[]{3, 3}));
		System.out.println(t.maxProfit(new int[]{3, 2, 1}));
		System.out.println(t.maxProfit(new int[]{1, 2, 1, 2, 3}));
	}
}
