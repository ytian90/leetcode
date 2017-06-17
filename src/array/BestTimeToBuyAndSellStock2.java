package array;
/**
 * Best Time to Buy and Sell Stock II
 * @author yutian
 * @since Aug 22, 2015
 */
public class BestTimeToBuyAndSellStock2 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if (diff > 0) profit += diff;
		}
		return profit;
	}
	
	// follow up about transFee
	public int maxProfit(int[] prices, int[] trans) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = (prices[i + 1] + trans[i + 1]) - (prices[i] - trans[i]);
			if (diff > 0) profit += diff;
		}
		return profit;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 t = new BestTimeToBuyAndSellStock2();
		System.out.println(t.maxProfit(new int[]{1, 2, 3}));
		System.out.println(t.maxProfit(new int[]{3, 3}));
		System.out.println(t.maxProfit(new int[]{3, 2, 1}));
		System.out.println(t.maxProfit(new int[]{1, 2, 1, 2, 3}));
	}
}
