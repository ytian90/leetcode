package leetcode.array;

/**
 * 562. Longest Line of Consecutive One in Matrix
 * @author ytian
 *
 */
public class LongestLineofConsecutiveOneinMatrix {
	// space O(4MN)
	public static int longestLine(int[][] M) {
		int n = M.length, max = 0;
		if (n == 0) return max;
		int m = M[0].length;
		int[][][] dp = new int[n][m][4];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (M[i][j] == 0) continue;
				for (int k = 0; k < 4; k++) {
					dp[i][j][k] = 1;
				}
				if (i > 0) dp[i][j][0] += dp[i - 1][j][0];
				if (j > 0) dp[i][j][1] += dp[i][j - 1][1];
				if (i > 0 && j > 0) dp[i][j][2] += dp[i - 1][j - 1][2];
				if (i > 0 && j < m - 1) dp[i][j][3] += dp[i - 1][j + 1][3];
				max = Math.max(max, Math.max(Math.max(dp[i][j][0], dp[i][j][1]),
						Math.max(dp[i][j][2], dp[i][j][3])));
			}
		}
		return max;
	}

	// space O(m + n)
	public static int longestLine2(int[][] M) {
		if (M.length == 0 || M[0].length == 0) {
			return 0;
		}
		int max = 0;
		int[] col = new int[M[0].length];
		int[] diag = new int[M.length + M[0].length];
		int[] adiag = new int[M.length + M[0].length];
		for (int i = 0; i < M.length; i++) {
			int row = 0;
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 1) {
					row++;
					col[j]++;
					diag[j + i]++;
					adiag[j - i + M.length]++;
					max = Math.max(max, row);
					max = Math.max(max, col[j]);
					max = Math.max(max, diag[j + i]);
					max = Math.max(max, adiag[j - i + M.length]);
				} else {
					row = 0;
					col[j] = 0;
					diag[j + i] = 0;
					adiag[j - i + M.length] = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] t = new int[][]{
				{1,1,1,1},
				{0,1,1,0},
				{0,0,0,1}
		};

		System.out.println(longestLine(t));
	}

}
