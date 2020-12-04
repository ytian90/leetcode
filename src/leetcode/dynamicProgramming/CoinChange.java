package leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * 322. Coin Change
 * @author yutian
 * @since Jan 14, 2016
 */
public class CoinChange {
	
	// Time ~O(n * amount) Space ~O(amount)
	public static int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0)
			return 0;
		if (amount <= 0) return 0;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int c : coins) {
			for (int i = c; i <= amount; i++) {
				if (c <= i) {
					int rest = i - c;
					if (dp[rest] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[rest] + 1);
					}
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		System.out.println(coinChange(new int[]{1, 2, 5}, 11));
		System.out.println(coinChange(new int[]{2}, 3));
	}

}
