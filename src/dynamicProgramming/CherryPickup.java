package dynamicProgramming;

import java.util.Arrays;

/**
 * 741. Cherry Pickup
 * @author ytian
 *
 */
public class CherryPickup {

	public static int cherryPickup(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int n = grid.length;
		int[][][] dp = new int[n + 1][n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				Arrays.fill(dp[i][j], Integer.MIN_VALUE);
			}
		}
		dp[1][1][1] = grid[0][0];
		for (int x1 = 1; x1 <= n; x1++) {
			for (int y1 = 1; y1 <= n; y1++) {
				for (int x2 = 1; x2 <= n; x2++) {
					int y2 = x1 + y1 - x2;
					if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1) {
						continue;
					}
					int curr = Math.max(Math.max(dp[x1 - 1][y1][x2 - 1], dp[x1][y1 - 1][x2 - 1]),
							Math.max(dp[x1 - 1][y1][x2], dp[x1][y1 - 1][x2]));
					if (curr < 0) {
						continue;
					}
					dp[x1][y1][x2] = curr + grid[x1 - 1][y1 - 1];
					if (x1 != x2) {
						dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
					}
				}
			}
		}
		return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
	}

	public static void main(String[] args) {
		System.out.println(cherryPickup(new int[][]{
				{0, 1, -1},
				{1, 0, -1},
				{1, 1, 1}
		}));
	}
	// time O(N^3) space O(N^2)
	public static int cherryPickup1(int[][] grid) {
		int N = grid.length;
		int[][] dp = new int[N][N];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		dp[0][0] = grid[0][0];
		for (int t = 1; t <= 2 * N - 2; t++) {
			int[][] dp2 = new int[N][N];
			for (int[] row : dp2) {
				Arrays.fill(row, Integer.MIN_VALUE);
			}
			for (int i = Math.max(0, t - (N - 1)); i <= Math.min(N - 1, t); i++) {
				for (int j = Math.max(0, t - (N - 1)); j <= Math.min(N - 1, t); j++) {
					if (grid[i][t - i] == -1 || grid[j][t - j] == -1) continue;
					int val = grid[i][t - i];
					if (i != j) val += grid[j][t - j];
					for (int pi = i - 1; pi <= i; pi++) {
						for (int pj = j - 1; pj <= j; pj++) {
							if (pi >= 0 && pj >= 0) {
								dp2[i][j] = Math.max(dp2[i][j], dp[pi][pj] + val);
							}
						}
					}
				}
			}
			dp = dp2;
		}
		return Math.max(0, dp[N - 1][N - 1]);
	}

	// time O(N^3) space O(N^3)
	int[][][] memo;
	int[][] grid;
	int N;
	
	public int cherryPickup0(int[][] grid) {
		this.grid = grid;
		N = grid.length;
		memo = new int[N][N][N];
		for (int[][] layer: memo) {
			for (int[] row : layer) {
				Arrays.fill(row, Integer.MIN_VALUE);
			}
		}
		return Math.max(0, dp(0, 0, 0));
	}
	
	public int dp(int r1, int c1, int c2) {
		int r2 = r1 + c1 - c2;
		if (N == r1 || N == r2 || N == c1 || N == c2 || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
			return -999999;
		} else if (r1 == N - 1 && c1 == N - 1) {
			return grid[r1][c1];
		} else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
			return memo[r1][c1][c2];
		} else {
			int res = grid[r1][c1];
			if (c1 != c2) res += grid[r2][c2];
			res += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)), 
					        Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2)));
			return res;
		}
	}
	
}
