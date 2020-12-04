package leetcode.math;

/**
 * Matrix Chain Multiplication
 * https://www.youtube.com/watch?v=vgLJZMUfnsU&index=3&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 *
 */
public class MatrixChainMultiplication {

    public static int findCost(int[] nums) {
        int n = nums.length, q = 0;
        int[][] dp = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    q = dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(findCost(new int[]{4, 2, 3, 5, 3}));
    }

}
