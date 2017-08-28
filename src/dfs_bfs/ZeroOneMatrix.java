package dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 542. 01 Matrix
 * @author ytian
 *
 */
public class ZeroOneMatrix {
	
	public static int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (matrix[i][j] == 0) {
        			q.offer(new int[]{i, j});
        		} else {
        			matrix[i][j] = Integer.MAX_VALUE;
        		}
        	}
        }
                
        while (!q.isEmpty()) {
        	int[] c = q.poll();
        	for (int[] d : dirs) {
        		int i = c[0] + d[0];
        		int j = c[1] + d[1];
        		if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] <= matrix[c[0]][c[1]] + 1) {
        			continue;
        		}
        		q.offer(new int[] {i, j});
        		matrix[i][j] = matrix[c[0]][c[1]] + 1;
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
