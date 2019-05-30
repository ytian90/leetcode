package dynamicProgramming;
/**
 * 304. Range Sum Query 2D - Immutable
 * @author yutian
 * @since Feb 14, 2016
 */
public class RangeSumQuery2DImmutable {
	
	private int[][] dp;
	// time O(mn)
	public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] 
        				+ matrix[i - 1][j - 1];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] 
        		+ dp[row1][col1];
    }

	public static void main(String[] args) {
		RangeSumQuery2DImmutable t = new RangeSumQuery2DImmutable(new int[][]{
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		});
		System.out.println(t.sumRegion(2, 1, 4, 3));
		System.out.println(t.sumRegion(1, 1, 2, 2));
		System.out.println(t.sumRegion(1, 2, 2, 4));
	}

}
