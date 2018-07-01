package dfs_bfs;
/**
 * 695. Max Area of Island
 * @author ytian
 *
 */
public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, helper(grid, i, j));
                }
            }
        }
        return res;
    }

    private static int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + helper(grid, i - 1, j)
                 + helper(grid, i + 1, j)
                 + helper(grid, i, j - 1)
                 + helper(grid, i, j + 1);
    }

	public static void main(String[] args) {
		int[][] a = new int[][]{
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		int[][] b = new int[][]{
			{0,0,0,0,0,0,0,0}
		};
		
		System.out.println(maxAreaOfIsland(a));
		System.out.println(maxAreaOfIsland(b));
	}

}
