package dfs_bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II
 * @author yutian
 *
 */
public class TrappingRainWater2 {
	
	public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
        	return 0;
        }
        PriorityQueue<Cell> q = new PriorityQueue<>(1, new Comparator<Cell>(){
        	public int compare(Cell a, Cell b) {
        		return a.height - b.height;
        	}
        });
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Initially, add all the cells which are on borders to the queue.
        for (int i = 0; i < m; i++) {
        	visited[i][0] = true;
        	visited[i][n - 1] = true;
        	q.offer(new Cell(i, 0, heightMap[i][0]));
        	q.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        for (int i = 0; i < n; i++) {
        	visited[0][i] = true;
        	visited[m - 1][i] = true;
        	q.offer(new Cell(0, i, heightMap[0][i]));
        	q.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!q.isEmpty()) {
        	Cell cell = q.poll();
        	for (int[] dir : dirs) {
        		int row = cell.row + dir[0];
        		int col = cell.col + dir[1];
        		if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
        			visited[row][col] = true;
        			res += Math.max(0, cell.height - heightMap[row][col]);
        			q.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
        		}
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = new int[][]{{1,4,3,1}, {3,2,1,3}, {2,3,3,2}};
		System.out.println(trapRainWater(test));
		
	}
	
	public static class Cell {
		int row;
		int col;
		int height;
		public Cell (int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}

}
