package dynamicProgramming;

/**
 * 518. Coin Change 2
 */
public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public static int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change(3, new int[]{2}));
        System.out.println(change(5, new int[]{5}));
    }
}
