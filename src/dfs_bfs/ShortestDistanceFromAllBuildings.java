package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings
 * @author yutian
 * @since Feb 15, 2016
 */
public class ShortestDistanceFromAllBuildings {
	
	// Method 1
	static final int[] d = new int[]{0, 1, 0, -1, 0};
	static int[][] distance;
	static int min;
	
	public int shortestDistance0(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		distance = new int[m][n];
		int start = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					helper(grid, i, j, start--);
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	
	private void helper(int[][] grid, int r, int c, int start) {
		int m = grid.length, n = grid[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{r, c});
		int level = 0;
		min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				for (int j = 0; j < 4; j++) {
					int x = curr[0] + d[j];
					int y = curr[1] + d[j + 1];
					if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == start) {
						q.offer(new int[]{x, y});
						distance[x][y] += level;
						min = Math.min(min, distance[x][y]);
						grid[x][y]--;
					}
				}
			}
		}
	}

	// Method 2
	final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	// time O(m^2*n^2)
	public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        	return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        int num = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			num++;
        			LinkedList<int[]> q = new LinkedList<>();
        			q.offer(new int[]{i, j});
        			
        			boolean[][] visited = new boolean[m][n];
        			int level = 1;
        			
        			while (!q.isEmpty()) {
        				int size = q.size();
        				for (int t = 0; t < size; t++) {
        					int[] curr = q.poll();
        					for (int[] dir: dirs) {
        						int row = curr[0] + dir[0];
        						int col = curr[1] + dir[1];
        						if (row >= 0 && row < m && col >= 0 && col < n
        								&& grid[row][col] == 0 && !visited[row][col]) {
        							distance[row][col] += level;
        							reach[row][col]++;
        							visited[row][col] = true;
        							q.offer(new int[]{row, col});
        						}
        					}
        				}
        				level++;
        			}
        		}
        	}
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 0 && reach[i][j] == num) {
        			result = Math.min(result, distance[i][j]);
        		}
        	}
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }

	public static void main(String[] args) {
		ShortestDistanceFromAllBuildings t = new ShortestDistanceFromAllBuildings();
		System.out.println(t.shortestDistance0(new int[][]{
				{1, 0, 2, 0, 1},
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0}}));
		
	}

}
