package dynamicProgramming;

/**
 * Egg drop problem
 * Given some number of floors and some number of eggs, what is the minimum
 * number of attempts it will take to find out from which floor egg will break.
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 */
public class EggDropProblem {

    /*
    n is number of floor
    k is number of eggs
     */
    public static int eggDrop(int n, int k) {
        if (n == 1 || n == 0)
            return n;
        if (k == 1) return n;
        int min = Integer.MAX_VALUE;
        int localMax = 0;
        for (int i = 1; i <= n; i++) {
            localMax = Math.max(eggDrop(i - 1, k - 1), eggDrop(n - i, k));
            min = Math.min(min, localMax);
        }
        return min + 1;
    }

    public static int eggDropDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int localMax = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int j = 1; j <= k; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    localMax = 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]);
                    dp[i][j] = Math.min(localMax, dp[i][j]);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(eggDropDP(9, 3));
        System.out.println(eggDropDP(10, 2));
    }
}
