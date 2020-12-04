package leetcode.dynamicProgramming;
/**
 * 63. Unique Path II with obstacles
 * @author yutian
 * @since Aug 1, 2015
 */
public class UniquePaths2 {
	// 2-d DP: Time ~ O(M*N), Space ~ O(M*N) 
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    d[i][j] = (obstacleGrid[i][j] == 1) ? 0 : 1;
                } else {
                    d[i][j] = (obstacleGrid[i][j] == 1) ? 0 :
                        ((i > 0) ? d[i - 1][j] : 0) + 
                        ((j > 0) ? d[i][j - 1] : 0);
                }
            }
        }
        return d[m - 1][n - 1];
	}
	
	// bottom incr
	public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] d = new int[m + 1][n + 1];
        d[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                d[i][j] = (obstacleGrid[i][j] == 1) ? 0 :
                    d[i + 1][j] + d[i][j + 1];
            }
        }
        return d[0][0];
	}
	
	// 1-d DP : Time ~ O(M*N), Space ~ O(min{M, N}) 
	public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int min = Math.min(m, n), max = Math.max(m, n);
		int[] steps = new int[min];
		int value;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < min; j++) {
				if (n == min) value = obstacleGrid[i][j];
				else value = obstacleGrid[j][i];
				if (i == 0 && j == 0) {
					steps[j] = value == 1 ? 0 : 1;
				} else {
					steps[j] = value == 1 ? 0 : ((i > 0) ? steps[j]: 0) 
							+ ((j > 0) ? steps[j - 1]: 0);
				}
			}
		}
		return steps[min - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][]{{0}}));
		System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 1, 0}}));
	}
}
