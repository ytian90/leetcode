package leetcode.dynamicProgramming;
/**
 * Dungeon Game
 * @author yutian
 * @since Dec 6, 2015
 */
public class DungeonGame {
	
	public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
        	return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        
        // fill out the last column
        for (int i = m - 2; i >= 0; i--) {
        	dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        
        // fill out the last row
        for (int j = n - 2; j >= 0; j--) {
        	dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        
        // fill out the rest of dp
        for (int i = m - 2; i >= 0; i--) {
        	for (int j = n - 2; j >= 0; j--) {
        		int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
        		int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
        		dp[i][j] = Math.min(right, down); // this is MIN
        	}
        }
        return dp[0][0];
    }

	public static void main(String[] args) {
		int[][] test1 = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		int[][] test2 = new int[][]{{100}};
		System.out.println(calculateMinimumHP(test1));
		System.out.println(calculateMinimumHP(test2));
	}

}
