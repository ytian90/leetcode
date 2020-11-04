package dynamicProgramming;

/**
 * 673. Number of Longest Increasing Subsequence
 */
public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, max_len = 0, res = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max_len == dp[i]) {
                res += count[i];
            } else if (max_len < dp[i]) {
                max_len = dp[i];
                res = count[i];
            }
        }
        return res;
    }


    public static int findNumberOfLIS2(int[] nums) {
        int n = nums.length, res = 0, max = 0;
        int[] len = new int[n], count = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    }
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max == len[i])
                res += count[i];
            if (max < len[i]) {
                max = len[i];
                res = count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7})); // 2
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2})); // 5
    }
}
