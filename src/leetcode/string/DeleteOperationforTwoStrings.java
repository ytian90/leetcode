package leetcode.string;
/**
 * 583. Delete Operation for Two Strings
 * @author ytian
 *
 */
public class DeleteOperationforTwoStrings {
	
	public static int minDistance(String word1, String word2) {
		int a = word1.length(), b = word2.length();
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i <= a; i++) {
        	for (int j = 0; j <= b; j++) {
        		if (i == 0 || j == 0) dp[i][j] = 0;
        		else dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 :
        			Math.max(dp[i - 1][j], dp[i][j - 1]);
        	}
        }
        int val = dp[a][b];
        return a - val + b - val;
    }

	public static void main(String[] args) {
		System.out.println(minDistance("sea", "eat"));
	}

}
