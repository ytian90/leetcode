package dynamicProgramming;
/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * @author yutian
 * @since Jan 3, 2016
 */
public class BestTimeToBuyAndSellStockWithCooldown {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int b0 = -prices[0], b1 = b0;
		int s0 = 0, s1 = 0, s2 = 0;
		for (int i = 0; i < prices.length; i++) {
			b0 = Math.max(b1, s2 - prices[i]);
			s0 = Math.max(s1, b1 + prices[i]);
			b1 = b0; s2 = s1; s1 = s0;
		}
		return s0;
	}

	public static void main(String[] args) {
		int[] test = new int[]{1, 2, 3, 0, 2};
		System.out.println(maxProfit(test));
	}

	/*
	 * Solution 1: Space O(n)
	 * https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
	 */
	public static int maxProfit1(int[] prices) {
		int len = prices.length;
        if (len <= 1) return 0;
        int[] s0 = new int[len]; // reset or buy (s0 -> s1)
        int[] s1 = new int[len]; // reset or sell (s1 -> s2)
        int[] s2 = new int[len]; // reset (s2 -> s0)
        s0[0] = 0; // At the start, you don't have any stock if you just rest
        s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
        s2[0] = Integer.MIN_VALUE; // Lower base case
        for (int i = 1; i < len; i++) {
        	s0[i] = Math.max(s0[i - 1], s2[i - 1]);
        	s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
        	s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[len - 1], s2[len - 1]);
    }
	
	/*
	 * Solution 2: Space O(1)
	 */
	public static int maxProfit2(int[] prices) {
		int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
		for (int i = 0; i < prices.length; i++) {
			int prevSold = sold;
			sold = hold + prices[i];
			hold = Math.max(hold, rest - prices[i]);
			rest = Math.max(rest, prevSold);
		}
		return Math.max(sold, rest);
	}

}
