package leetcode.dfs_bfs;
/**
 * 279. Perfect Squares
 * @author yutian
 * @since Sep 14, 2015
 */
public class PerfectSquares {
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				min = Math.min(min, dp[i - j * j] + 1);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 15; i++) {
			System.out.println("i = " + i + " res: " + numSquares(i));
		}
	}

	public int numSquare2(int n) {
		while (n % 4 == 0) n /= 4;
		if (n % 8 == 7) return 4;
		for (int a = 0; a * a <= n; ++a) {
			int b = (int) Math.sqrt(n - a * a);
			if (a * a + b * b == n)
				return a == 0 ? 1 : 2;
		}
		return 3;
	}
}
