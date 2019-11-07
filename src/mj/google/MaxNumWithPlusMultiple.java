package mj.google;

import java.util.List;

/**
 * 一个只有正整数的list， 其中插入+， * 或者（），求得到式子最大的值。 e.g. [1，2，1，2 ]->  (1+2)*(1+2)=9.  dp解，
 * follow up， 如果有负数该怎么办， 如果想要拿到最大的式子该怎么办。
 * 思路：类似burst balloon dp[i][j] = max of for (k : i ~ j  max(dp[i][k - 1] * dp[k][j], dp[i][k - 1] + dp[k][j]))
 */
public class MaxNumWithPlusMultiple {
    public int max(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int i : nums) {
            num[n++] = i;
        }
        num[0] = nums[n++] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][i - 1] * dp[i][right], dp[left][i - 1] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
