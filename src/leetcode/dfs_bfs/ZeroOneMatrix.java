package leetcode.dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 542. 01 Matrix
 * @author ytian
 *
 */
public class ZeroOneMatrix {

	private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new int[][]{};
		int n = matrix.length, m = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[]{i, j});
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		while (!q.isEmpty()) {
			int[] c = q.poll();
			int i = c[0], j = c[1];
			for (int[] d : dirs) {
				int x = i + d[0], y = j + d[1];
				if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= matrix[i][j] + 1)
					continue;
				q.add(new int[]{x, y});
				matrix[x][y] = matrix[i][j] + 1;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] t1 = new int[][]{
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
		};
		
		int[][] t2 = new int[][]{
			{0, 0, 0},
			{0, 1, 0},
			{1, 1, 1}
		};
		
		for (int[] a : updateMatrix(t1)) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println();
		
		for (int[] a : updateMatrix(t2)) {
			System.out.println(Arrays.toString(a));
		}
	}

}
