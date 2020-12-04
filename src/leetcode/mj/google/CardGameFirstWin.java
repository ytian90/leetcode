package leetcode.mj.google;

/**
 *
 */
public class CardGameFirstWin {
    // pick 2
    public static boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                dp[i] = values[i];
            } else if (i == n - 2) {
                dp[i] = values[i] + values[i + 1];
            } else {
                dp[i] = Math.max(values[i] - dp[i + 1], values[i] + values[i + 1] - dp[i + 2]);
            }
        }
        return dp[0] >= 0;
    }

    // pick 3
    public static boolean firstWillWin2(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                dp[i] = values[i];
            } else if (i == n - 2 || i == n - 3) {
                dp[i] = values[i] + dp[i + 1];
            } else {
                dp[i] = Math.max(Math.max(values[i] - dp[i + 1], values[i] + values[i + 1] - dp[i + 2]), values[i] + values[i + 1] + values[i + 2] - dp[i + 3]);
            }
        }
        return dp[0] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin2(new int[]{100, 1, -1, 2, 200, 1}));
        System.out.println(firstWillWin2(new int[]{100, 1, -1, 200, 2, 1}));
    }
}
