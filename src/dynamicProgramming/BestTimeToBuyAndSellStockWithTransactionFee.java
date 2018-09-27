package dynamicProgramming;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] hold = new int[n], sold = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return sold[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
