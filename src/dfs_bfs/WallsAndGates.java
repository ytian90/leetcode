package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates
 * @author yutian
 * @since Jan 3, 2016
 */
public class WallsAndGates {
	
	private static final int R = Integer.MAX_VALUE;
	
	// DFS
	public void wallsAndGates2(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j, 0);
				}
			}
		}
	}

	private void dfs(int[][] rooms, int i, int j, int d) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1)
			return;
		if (d == 0 || d < rooms[i][j]) {
			rooms[i][j] = d;
			dfs(rooms, i + 1, j, d + 1);
			dfs(rooms, i - 1, j, d + 1);
			dfs(rooms, i, j - 1, d + 1);
			dfs(rooms, i, j + 1, d + 1);
		}
	}
	
	// BFS
	public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) 
        	return;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
        	for (int j = 0; j < rooms[0].length; j++) {
        		if (rooms[i][j] == 0) q.add(new Point(i, j));
        	}
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
        	Point curr = q.poll();
        	for (int[] d: dirs) {
        		int i = curr.x + d[0];
        		int j = curr.y + d[1];
        		if (i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length 
        				&& rooms[i][j] == Integer.MAX_VALUE) {
        			rooms[i][j] = rooms[curr.x][curr.y] + 1;
        			q.add(new Point(i, j));
        		}
        	}
        }
    }
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{R, -1, 0, R},
									 {R, R, R, -1},
									 {0, -1, R, -1},
									 {R, -1, R, R}};
		WallsAndGates t = new WallsAndGates();
		t.print(matrix);
		t.wallsAndGates(matrix);
		t.print(matrix);
	}
	
	public void print(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
            	System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println();
	}

}
