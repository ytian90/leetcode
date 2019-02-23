package dynamicProgramming;

/**
 * Given a 2 dimensional matrix, find minimum cost path to reach bottom
 * right from top left provided you can only from down and right.
 * https://www.youtube.com/watch?v=lBRtnuxg-gU&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=21
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */
public class MinimumCostPath {

    public static int minCost(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
                {1, 3, 5, 8},
                {4, 2, 1, 7},
                {4, 3, 2, 3}
        }));
    }
}
