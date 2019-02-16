package dynamicProgramming;

/**
 * 474. Ones and Zeroes
 */
public class OnesAndZeroes {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] c = helper(s);
            for (int i = m; i >= c[0]; i--) {
                for (int j = n; j >= c[1]; j--) {
                    dp[i][j] = Math.max(1 + dp[i - c[0]][j - c[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static int[] helper(String s) {
        int[] res = new int[2];
        for (Character c : s.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
