package dynamicProgramming;

import java.util.Arrays;

/**
 * 322. Coin Change
 * @author yutian
 * @since Jan 14, 2016
 */
public class CoinChange {
	
	// Time ~O(n * amount) Space ~O(amount)
	public static int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0) return -1;
        if (amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int am = 1; am < dp.length; am++) {
            for (int c : coins) {
                if (c <= am) {
                    int sub = am - c;
                    if (dp[sub] != Integer.MAX_VALUE) {
                        dp[am] = Math.min(dp[am], dp[sub] + 1);
                    }
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		System.out.println(coinChange2(new int[]{186, 419, 83, 408}, 6249));
	}
	
	public static int coinChange2(int[] coins, int amount) {
		if (coins == null || coins.length == 0) return -1;
		if (amount < 1) return 0;
		int[] dp = new int[amount + 1];
		int sum = 0;
		while (++sum <= amount) {
			int min = -1;
			for (int coin: coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					min = min < 0 ? temp : (temp < min ? temp : min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}

	

}
